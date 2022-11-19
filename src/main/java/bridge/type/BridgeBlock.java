package bridge.type;

public enum BridgeBlock {

    DOWN(0, "D"),
    UP(1, "U");

    private final Integer valueType;
    private final String blockType;

    BridgeBlock(Integer valueType, String blockType) {
        this.valueType = valueType;
        this.blockType = blockType;
    }

    public static String getBlockType(Integer valueType) {
        if (valueType == DOWN.valueType) return DOWN.blockType;
        if (valueType == UP.valueType) return UP.blockType;
        return null;
    }
}
