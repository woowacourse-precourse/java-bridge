package bridge.domain;

public class BridgeGameStatus {
    private static final int INIT_TRY_COUNT = 1;
    private static final int ADD_TRY_COUNT = 1;
    private Status status;
    private int tryCount;

    public BridgeGameStatus() {
        this.status = Status.START;
        this.tryCount = INIT_TRY_COUNT;
    }

    public boolean canPlayGame() {
        return status.getStatus();
    }

    public String getStatusMessage() {
        return status.getMessage();
    }

    public void updateStatus(Status status) {
        this.status = status;
    }

    public void retryStatus() {
        tryCount += ADD_TRY_COUNT;
        status = Status.START;
    }

    public int getTryCount() {
        return tryCount;
    }
}