package bridge.constant;

public enum BridgeConstant {
    LEFT_WRAPPER("[ "),
    RIGHT_WRAPPER(" ]"),
    JOINT(" | "),
    CAN_GO("O"),
    CAN_NOT_GO("X");

    private final String bridgeConstant;

    BridgeConstant(String bridgeConstant) {
        this.bridgeConstant = bridgeConstant;
    }

    public String getBridgeConstant() {
        return bridgeConstant;
    }
}
