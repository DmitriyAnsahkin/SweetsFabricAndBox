package SweetsFabricAndBox.Factory;

import SweetsFabricAndBox.Sweet.Marmelade;
import SweetsFabricAndBox.Sweet.Size;
import SweetsFabricAndBox.Sweet.Sweets;

public class MarmeladeFactory implements SweetFactoryWithSize{

    @Override
    public Sweets createSweet(Size size) {
        return new Marmelade(Size.SMALL);
    }
}
