package SweetsFabricAndBox.Sweet;

import SweetsFabricAndBox.Factory.SweetFactoryWithSize;
import SweetsFabricAndBox.Factory.SweetsFactory;

public abstract class Sweets implements SweetsFactory, SweetFactoryWithSize, PrintInfo {
    public Size size;
    public String typeSweet;

    Sweets(){
        this.typeSweet = "";
        this.size = Size.MIDDLE;
    }
    Sweets(Size size){
        this.typeSweet = "";
        this.size = size;
    }


}
