package SweetsFabricAndBox.Sweet;

import SweetsFabricAndBox.Sweet.Sweets;
import SweetsFabricAndBox.Sweet.TypeSweet;

public class Candy extends Sweets {

    public Candy() {
        this.typeSweet = TypeSweet.CANDY.name();
    }
    public Candy(Size size) {
        this.typeSweet = TypeSweet.CANDY.name();
        this.size = size;
    }


    public void printInfo() {
        System.out.println();
    }

    @Override
    public Sweets createSweets() {
        return null;
    }

    @Override
    public void printInfo(Sweets sweets) {

    }

    @Override
    public Sweets createSweet(Size size) {
        return null;
    }
}
