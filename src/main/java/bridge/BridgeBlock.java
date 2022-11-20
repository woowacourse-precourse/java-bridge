package bridge;

public enum BridgeBlock {
    UPPER_BLOCK("U"),
    LOWER_BLOCK("D");

    private final String bridgeBlock;

    BridgeBlock(String bridgeBlock) {
        this.bridgeBlock = bridgeBlock;
    }

    public String getBridgeBlock() {
        return bridgeBlock;
    }
}
