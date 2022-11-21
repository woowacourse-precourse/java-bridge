package bridge.Enum;

public enum Result {
    SURVIVE("O"),
    FAIL("X"),
    SPACE(" "),
    ;

    private String sign;

    Result(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return this.sign;
    }
}
