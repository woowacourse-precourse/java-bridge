package bridge.domain;

public enum BridgeBlock {
    X(" X "),
    O(" O "),
    EMPTY("   ");

    private final String bridgeBlock;

    BridgeBlock(String bridgeBlock) {
        this.bridgeBlock = bridgeBlock;
    }

    public String getBridgeBlock() {
        return bridgeBlock;
    }
}
