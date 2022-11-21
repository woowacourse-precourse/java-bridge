package bridge.constant;

public enum Sign {
    LEFT_PARENTHESIS("[ "),
    RIGHT_PARENTHESIS("  ]"),
    RIGHT__PARENTHESIS_STRING("%s ]\n"),
    MIDDLE_LINE("  | "),
    MIDDLE_LINE_STRING("%s | ");

    private String sign;

    Sign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
