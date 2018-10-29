package SweetsFabricAndBox.Box;

import SweetsFabricAndBox.Sweet.PrintInfo;
import SweetsFabricAndBox.Sweet.Size;
import SweetsFabricAndBox.Sweet.Sweets;
import SweetsFabricAndBox.Sweet.TypeSweet;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Box implements PrintInfo{
    private  double weight = 0;
    private double maxWeight = 1000;
    private double price;
    private ArrayList<Sweets> boxContent = new ArrayList<>();

    private Predicate testSweets;

    public void add (Sweets sweets){
        if (testSweets.testSweet(sweets)){
            boxContent.add(sweets);
            String str = sweets.size.name();
            switch (str){
                case "VERY_SMALL":
                    if (checkMaxSize(1)) this.weight += 1;
                    break;
                case "SMALL":
                    if (checkMaxSize(2)) this.weight += 2;
                    break;
                case "MIDDLE":
                    if (checkMaxSize(3)) this.weight += 3;
                    break;
                case "BIG":
                    if (checkMaxSize(4)) this.weight += 4;
                    break;
                case "MONSTER":
                    if (checkMaxSize(5)) this.weight += 5;
                    break;


            }
        }
    }

    private boolean checkMaxSize (double weight){
        if ((this.weight += weight) > this.maxWeight) return true;
        return false;
    }

    public void info (){
        System.out.println("Всего в коробке " + this.boxContent.size() + " сладостей, общий вес коробки: " + this.weight);
    }

    public void changePolicyAdd (TypeSweet typeSweet){
        testSweets = sweets -> !sweets.typeSweet.equals(typeSweet.name());
    }


    @Override
    public void printInfo(Sweets sweets) {

    }


    public void infoContentByType (TypeSweet typeSweet){
        long a = boxContent.stream()
                .filter(s -> s.typeSweet.equals(typeSweet.name()))
                .count();
        System.out.println("В коробке " + a + " " + typeSweet.name());
    }
    public void infoContentByType (Size size){
        long a = boxContent.stream()
                .filter(s -> s.size.name().equals(size.name()))
                .count();
        System.out.println("В коробке " + a + " сладостей размера " + size.name());
    }
}
