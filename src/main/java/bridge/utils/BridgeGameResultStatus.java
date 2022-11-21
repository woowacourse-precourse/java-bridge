package bridge.utils;

public enum BridgeGameResultStatus {
    CORRECT("O"),
    FAIL("X");

    private final String resultStatus;

    BridgeGameResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getResultStatus() {
        return resultStatus;
    }
}