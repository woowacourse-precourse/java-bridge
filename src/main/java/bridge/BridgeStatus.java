package bridge;

public enum BridgeStatus {
    CROSS_STATUS("O"),
    NOT_CROSS_STATUS("X");

    private final String status;

    BridgeStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
