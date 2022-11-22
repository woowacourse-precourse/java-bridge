package bridge.domain;

public enum BridgeSign {
    MOVE_SUCCESS("O"),
    MOVE_FAIL("X"),
    SPACE(" ");

    private String sign;

    BridgeSign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

}
