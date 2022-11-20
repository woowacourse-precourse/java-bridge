package bridge.config;

public enum BridgeStatus {
    INVALID("invalid", -1), UP("U", 1), DOWN("D", 0);

    private String position;
    private int value;

    private BridgeStatus(String position, int value) {
        this.position = position;
        this.value = value;
    }

    public String getPosition() {
        return this.position;
    }

    public BridgeStatus getBridgeStatusByValue(int value) {
        if(value == 1) {
            return UP;
        }
        return DOWN;
    }
}
