package SweetsFabricAndBox;

import SweetsFabricAndBox.Box.Box;
import SweetsFabricAndBox.Box.Converter;
import SweetsFabricAndBox.Factory.CandyFactory;
import SweetsFabricAndBox.Factory.MarmeladeFactory;
import SweetsFabricAndBox.Factory.SweetFactoryWithSize;
import SweetsFabricAndBox.Factory.SweetsFactory;
import SweetsFabricAndBox.Sweet.*;
import SweetsFabricAndBox.Sweet.Candy;
import SweetsFabricAndBox.Sweet.Marmelade;

import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        //Просто создание экзепляра класса вручную
        Candy candy = new Candy();
        //тут Я создаю экземпляры классов интерфейсов SweetsFactory и SweetFactoryWithSize
        //которые ничего не знают еще про конфеты, сладости и т.д. да и не должны знать, в любой момент могут появиться новые сладости
        //и использую статические ссылки на конструкторы (20, 21, 24 и 25 строки.)
        //при это в строках 24 и 25 Я просто переопределяю класс создаваемого объекта
        //Используя два интерфейса Я могу создавать конфеты с помощью перегруженных конструкторов классов

        SweetsFactory sweetsFactory = Candy::new;
        SweetFactoryWithSize sweetFactoryWithSize = Candy::new;
        Candy candyDefault = (Candy) sweetsFactory.createSweets();
        Candy candyWithSize = (Candy) sweetFactoryWithSize.createSweet(Size.MONSTER);
        sweetsFactory = Marmelade::new;
        sweetFactoryWithSize = Marmelade::new;
        Marmelade marmeladeFDeafaul = (Marmelade) sweetsFactory.createSweets();
        Marmelade marmeladeWithSize = (Marmelade) sweetFactoryWithSize.createSweet(Size.SMALL);
        //сдесь Я тоже использую функциональный интерфейс для определения метода печати сладости
        PrintInfo printInfo = (Sweets -> System.out.println(Sweets.typeSweet +" "+ Sweets.size));
        //и печатаю их, какие-то создались с дефолтным размером, какие-то с заданным вручную
        printInfo.printInfo(candyDefault);
        printInfo.printInfo(candyWithSize);
        printInfo.printInfo(marmeladeFDeafaul);
        printInfo.printInfo(marmeladeWithSize);
        //создаю две сладости с помощью двух фабрик как отдельных классов
        CandyFactory candyFactory = new CandyFactory();
        MarmeladeFactory marmeladeFactory = new MarmeladeFactory();
        Sweets candyFromFactory = candyFactory.createSweets();
        Sweets marmeladeFromFactory = marmeladeFactory.createSweet(Size.BIG);
        //сейчас создаем Box, описываем политику добавления (нельзя класть сладости одного из типов, и пытаемся в него положить вкусняшки.
        //Candy не должны добавляться
        Box box = new Box();
        box.changePolicyAdd(TypeSweet.CANDY);
        //печатаем информацию о коробке
        box.info();
        box.add(candyDefault);
        box.add(candyWithSize);
        box.add(marmeladeFDeafaul);
        box.add(marmeladeWithSize);
        box.add(candyFromFactory);
        box.add(marmeladeFromFactory);
        box.info();
        //теперь меняем политику и пробуем заного
        box.changePolicyAdd(TypeSweet.NULL);
        box.add(candyDefault);
        box.add(candyWithSize);
        box.add(marmeladeFDeafaul);
        box.add(marmeladeWithSize);
        box.add(candyFromFactory);
        box.add(marmeladeFromFactory);
        box.info();
        //а это перегруженный метод определяющий количество сладостей по названию или размеру
        box.infoContentByType(TypeSweet.CANDY);
        box.infoContentByType((Size.MIDDLE));
        //
        Converter conver = (double a,Box b) -> (b.getPrice()/a);
        //конвертация цены в валюту. Курс 65.4
        System.out.println(conver.conver(65.4, box));



    }
}
