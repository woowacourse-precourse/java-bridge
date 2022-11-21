package bridge.model.domain;

public enum BridgeSign {
    MOVABLE("O"),
    IMMOVABLE("X"),
    EMPTY(" ");

    private final String sign;

    BridgeSign(String sign) {
        this.sign = sign;
    }

    public static BridgeSign create(boolean isEdge, boolean isRightCurrentBridgePick, boolean isRightLastBridgePick) {
        if (isRightCurrentBridgePick && (!isEdge || isRightLastBridgePick)) {
            return BridgeSign.MOVABLE;
        }
        if (!isRightLastBridgePick && !isRightCurrentBridgePick && isEdge) {
            return BridgeSign.IMMOVABLE;
        }
        return BridgeSign.EMPTY;
    }

    public String getSign() {
        return sign;
    }
}
