package bridge.enums;

public enum BridgeStatus {
    AVAILABLE("O"),
    UNAVAILABLE("X"),
    EMPTY(" ");

    private String status;

    BridgeStatus(String status) {
        this.status = status;
    }

    public boolean equals(String status) {
        return this.status.equals(status);
    }

    public String getValue() {
        return this.status;
    }
}
