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

    public String getIngredient() {
        return ingredient;
    }
}
