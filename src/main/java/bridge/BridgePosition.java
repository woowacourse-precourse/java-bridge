package bridge;

public enum BridgePosition {
    UP(1, "U"),
    DOWN(0, "D"),
    NOT_FOUND(-1, "");

    private final int value;
    private final String letter;

    BridgePosition(int value, String letter) {
        this.value = value;
        this.letter = letter;
    }

    public int getValue() {
        return value;
    }

    public String getLetter() {
        return letter;
    }

    public static BridgePosition findPosition(int value) {
        for (BridgePosition bridgePosition : BridgePosition.values()) {
            if (bridgePosition.value == value) {
                return bridgePosition;
            }
        }
        return NOT_FOUND;
    }
}
