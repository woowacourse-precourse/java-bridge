package bridge.type;

public enum BridgeBlock {

    DOWN(0, "D"),
    UP(1, "U");

    private final Integer blockNumber;
    private final String blockSymbol;

    BridgeBlock(Integer blockNumber, String blockSymbol) {
        this.blockNumber = blockNumber;
        this.blockSymbol = blockSymbol;
    }

    public static String getBlockType(Integer blockNumber) {
        if (blockNumber == DOWN.blockNumber) return DOWN.blockSymbol;
        if (blockNumber == UP.blockNumber) return UP.blockSymbol;
        return null;
    }
}
