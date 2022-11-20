package bridge.view.sign;

public enum ResultSign {
    OPEN_BRACKET("[ "),
    EMPTY_SPACE(" "),
    ANSWER("O"),
    WRONG_ANSWER("X"),
    SEPARATOR(" | "),
    CLOSE_BRACKET(" ]\n");

    private final String sign;

    ResultSign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
