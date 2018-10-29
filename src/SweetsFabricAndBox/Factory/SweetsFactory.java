package SweetsFabricAndBox.Factory;

import SweetsFabricAndBox.Sweet.Sweets;

@FunctionalInterface
public interface SweetsFactory {
    public Sweets createSweets();
}
