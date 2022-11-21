package bridge.enums;

public enum Sign {
    CORRECT("O"),
    WRONG("X"),
    BLANK(" "),
    ;

    private final String sign;

    Sign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
