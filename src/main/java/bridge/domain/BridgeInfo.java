package bridge.domain;

public enum BridgeInfo {
    BRIDGE_BOTTOM(0, "D"),
    BRIDGE_TOP(1, "U");

    private final int positionNumber;
    private final String position;

    BridgeInfo(int positionNumber, String position) {
        this.positionNumber = positionNumber;
        this.position = position;
    }

    public int getPositionNumber() {
        return positionNumber;
    }

    public String getPosition() {
        return position;
    }
}
