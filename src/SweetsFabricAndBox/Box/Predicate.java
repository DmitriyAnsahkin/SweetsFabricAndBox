package SweetsFabricAndBox.Box;

import SweetsFabricAndBox.Sweet.Sweets;

@FunctionalInterface
public interface Predicate {
    boolean testSweet (Sweets sweets);
}
