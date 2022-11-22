package bridge.domain;

public enum RestartSign {
    QUIT("Q"),
    RESTART("R");

    private String sign;

    RestartSign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
