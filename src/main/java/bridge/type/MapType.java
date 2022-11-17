package bridge.type;

public enum MapType {

    START("[ "),

    END(" ]"),

    CORRECT("O"),

    WRONG("X"),

    BLANK(" "),

    SEPARATOR(" | ");

    private final String sign;

    MapType(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
