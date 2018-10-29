package SweetsFabricAndBox.Sweet;

public enum TypeSweet {
    CHOCOLATE,
    LOLLILOP,
    MARMELADE,
    COOKIE,
    CAKE,
    BIZE,
    PASTE,
    CANDY,
    NULL;

    public static String getString (TypeSweet typeSweet){
        return typeSweet.name();
    }
}

