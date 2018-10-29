package SweetsFabricAndBox.Factory;

import SweetsFabricAndBox.Sweet.Candy;
import SweetsFabricAndBox.Sweet.Sweets;

public class CandyFactory implements SweetsFactory{

    @Override
    public Sweets createSweets() {
        return new Candy();
    }
}
