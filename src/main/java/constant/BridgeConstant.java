package constant;

public enum BridgeConstant {
    BRIDGE_SIZE_START_INCLUSIVE(3),
    BRIDGE_SIZE_END_INCLUSIVE(20);

    public final int bridgeConstant;

    BridgeConstant(final int bridgeConstant) {
        this.bridgeConstant = bridgeConstant;
    }

    public int getConstant() {
        return bridgeConstant;
    }
}
