package SweetsFabricAndBox.Factory;

import SweetsFabricAndBox.Sweet.Size;
import SweetsFabricAndBox.Sweet.Sweets;

@FunctionalInterface
public interface SweetFactoryWithSize {
    public Sweets createSweet(Size size);
}
