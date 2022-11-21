package bridge.constant;

public enum Sign {
    LEFT_PARENTHESIS("["),
    RIGHT_PARENTHESIS("]"),
    MIDDLE_LINE("|");

    private String sign;

    Sign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
