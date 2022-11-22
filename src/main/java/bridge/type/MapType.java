package bridge.type;

public enum MapType {

    START("[ "),
    END(" ]"),
    SEPARATOR(" | "),

    BLANK(" "),

    CORRECT("O"),

    WRONG("X"),

    UP_CORRECT("UO"),

    UP_WRONG("UX"),

    DOWN_CORRECT("DO"),

    DOWN_WRONG("DX");

    private final String sign;

    MapType(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
