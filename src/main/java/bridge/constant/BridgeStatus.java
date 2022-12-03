package bridge.constant;

public enum BridgeStatus {
    DOWN("D"),
    UP("U");

    private final String status;
    BridgeStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
