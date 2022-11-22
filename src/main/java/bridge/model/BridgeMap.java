package bridge.model;

public enum BridgeMap {
    BEGIN("[ "),
    END(" ]"),
    DELIMITER(" | "),
    ABLE("O"),
    DISABLE("X"),
    NONE(" ");

    private final String sign;
    BridgeMap(String sign) {
        this.sign = sign;
    }
    public String getSign() {
        return this.sign;
    }
}
