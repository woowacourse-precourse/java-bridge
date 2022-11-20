package bridge.identifiers;

public enum Direction {
    ERR(-1, "!"), DOWN(0, "D"), UP(1, "U");

    private int asInt;
    private String asString;

    Direction(int intValue, String stringValue){
        this.asInt = intValue;
        this.asString = stringValue;
    }

    public int getAsInt() {
        return asInt;
    }

    public String getAsString() {
        return asString;
    }
}
