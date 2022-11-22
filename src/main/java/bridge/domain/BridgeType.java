package bridge.domain;

public enum BridgeType {
    UP(1, "U"),
    DOWN(0, "D");

    private final int number;
    private String type;

    BridgeType(int number, String type) {
        this.number = number;
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public static BridgeType valueOfNumber(int number) {
        BridgeType bridgeType = null;

        if (number == 0) {
            bridgeType = DOWN;
        }
        if (number == 1) {
            bridgeType = UP;
        }

        return bridgeType;
    }
}
