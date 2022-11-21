package bridge;

public enum BridgeBlock {
    UPPER_BLOCK("U"),
    LOWER_BLOCK("D");

    private final String bridgeBlock;

    BridgeBlock(String bridgeBlock) {
        this.bridgeBlock = bridgeBlock;
    }

    public static BridgeBlock getBridgeBlockType(String bridgeBlock) {
        if (bridgeBlock.equals("U")) {
            return BridgeBlock.UPPER_BLOCK;
        }
        return BridgeBlock.LOWER_BLOCK;
    }

    public String getBridgeBlock() {
        return bridgeBlock;
    }
}
