package bridge.config;

public enum BridgeStatus {
    INVALID(-1), UP(1), DOWN(0);

    private int value;

    private BridgeStatus(int value) {
        this.value = value;
    }

    public BridgeStatus getBridgeStatus(int value) {
        if(value == 1) {
            return UP;
        }
        return DOWN;
    }
}
