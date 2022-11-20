package bridge.identifiers;

public enum Direction {
    ERR(-1, "!"), DOWN(0, "D"), UP(1, "U");

    private int asInt;
    private String asString;

    Direction(int intValue, String stringValue) {
        this.asInt = intValue;
        this.asString = stringValue;
    }

    public int getAsInt() {
        return asInt;
    }

    public String getAsString() {
        return asString;
    }

    public static Direction parseDirection(String directionValue) {
        if (directionValue == DOWN.asString)
            return DOWN;
        if (directionValue == UP.asString)
            return UP;
        return ERR;
    }

    public static Direction parseDirection(int directionValue){
        if (directionValue == DOWN.asInt)
            return DOWN;
        if (directionValue == UP.asInt)
            return UP;
        return ERR;
    }
}
