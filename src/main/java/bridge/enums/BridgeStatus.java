package bridge.enums;

public enum BridgeStatus {
    UPPER("U"),
    LOWER("D");

    private final String status;

    BridgeStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
