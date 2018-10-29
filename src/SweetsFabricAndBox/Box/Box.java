package SweetsFabricAndBox.Box;

import SweetsFabricAndBox.Sweet.PrintInfo;
import SweetsFabricAndBox.Sweet.Size;
import SweetsFabricAndBox.Sweet.Sweets;
import SweetsFabricAndBox.Sweet.TypeSweet;

import java.util.ArrayList;

public class Box implements PrintInfo{
    private  double weight = 0;
    private double maxWeight = 1000;
    private double price = 0;
    private ArrayList<Sweets> boxContent = new ArrayList<>();

    private Predicate testSweets;




    public void add (Sweets sweets){
        if (testSweets.testSweet(sweets)){
            boxContent.add(sweets);
            String str = sweets.size.name();
            switch (str){
                case "VERY_SMALL":
                    if (raisePriceAndWeight(1)) {
                        this.weight += 1;
                        this.price +=1;
                    }
                    break;
                case "SMALL":
                    if (raisePriceAndWeight(2)) {
                        this.weight += 2;
                        this.price += 5;
                    }
                    break;
                case "MIDDLE":
                    if (raisePriceAndWeight(3)) {
                        this.weight += 3;
                        this.price += 15;
                    }
                    break;
                case "BIG":
                    if (raisePriceAndWeight(4)) {
                        this.weight += 4;
                        this.price += 25;
                    }
                    break;
                case "MONSTER":
                    if (raisePriceAndWeight(5)) {
                        this.weight += 5;
                        this.price += 85;
                    }
                    break;


            }
        }
    }

    private boolean raisePriceAndWeight(double weight){
        double a = this.weight;
        a += weight;
        if (a < 100) return true;
        return false;
    }

    public void info (){
        System.out.println("Всего в коробке " + this.boxContent.size() + " сладостей, общий вес коробки: " + this.weight +
        " и ее стоимость: " + this.price);
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

    public double getPrice() {
        return price;
    }
}
