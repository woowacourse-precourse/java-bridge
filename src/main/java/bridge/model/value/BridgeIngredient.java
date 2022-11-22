package bridge.model.value;

public enum BridgeIngredient {
    START("["),    //START, MATCH, SEPARATOR, NOT_MATCH, END
    SEPARATOR("|"),
    MATCH("O"),
    NOT_MATCH("X"),
    BLANK(" "),
    END("]");
    private final String ingredient;
    BridgeIngredient(String ingredient){
        this.ingredient = ingredient;
    }

    public static boolean contains(String input) {
        for(BridgeIngredient ingredient : BridgeIngredient.values()){
            if(ingredient.getIngredient().equals(input)){
                return true;
            }
        }
        return false;
    }

    public String getIngredient() {
        return ingredient;
    }
}
