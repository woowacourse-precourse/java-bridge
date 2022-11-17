package bridge.model.value;

public enum BridgeIngredient {
    START("[ "),
    SEPARATOR("| "),
    MATCH("O "),
    NOT_MATCH("X "),
    END("]");
    private final String ingredient;
    BridgeIngredient(String ingredient){
        this.ingredient = ingredient;
    }

    public String getIngredient() {
        return ingredient;
    }
}
