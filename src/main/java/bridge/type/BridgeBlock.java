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

    public static String getBlockSymbolByNumber(Integer blockNumber) {
        if (blockNumber == DOWN.blockNumber) return DOWN.blockSymbol;
        if (blockNumber == UP.blockNumber) return UP.blockSymbol;
        return null;
    }

    public String getBlockSymbol() {
        if (this == DOWN) return DOWN.blockSymbol;
        if (this == UP) return UP.blockSymbol;
        return null;
    }
}
