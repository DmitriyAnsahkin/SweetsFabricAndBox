package SweetsFabricAndBox.Sweet;

import SweetsFabricAndBox.Sweet.Sweets;
import SweetsFabricAndBox.Sweet.TypeSweet;

public class Marmelade extends Sweets {

    public Marmelade() {
        this.typeSweet = TypeSweet.MARMELADE.name();
    }

    public Marmelade(Size size) {
        this.typeSweet = TypeSweet.MARMELADE.name();
        this.size = size;
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