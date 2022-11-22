package bridge.constant;

public enum BridgePrintSign {
    MOVABLE("O"),
    IMMOVABLE("X"),
    EMPTY(" ");

    private final String sign;

    BridgePrintSign(String sign) {
        this.sign = sign;
    }

    public static BridgePrintSign create(boolean isEdge, boolean isRightCurrentBridgePick, boolean isRightLastBridgePick) {
        if (isRightCurrentBridgePick && (!isEdge || isRightLastBridgePick)) {
            return BridgePrintSign.MOVABLE;
        }
        if (!isRightLastBridgePick && !isRightCurrentBridgePick && isEdge) {
            return BridgePrintSign.IMMOVABLE;
        }
        return BridgePrintSign.EMPTY;
    }

    public String getSign() {
        return sign;
    }
}
