package bridge.domain;

public class BridgeGameStatus {
    private Status status;
    private int tryCount;

    public BridgeGameStatus() {
        this.status = Status.START;
        this.tryCount = 1;
    }

    public void addTryCount() {
    }

    public boolean canPlayGame() {
        return status.getStatus();
    }

    public String getStatusMessage(){
        return status.getMessage();
    }

    public void updateStatus(Status status) {
        this.status = status;
    }

    public void retryStatus() {
        tryCount+=1;
        status = Status.START;
    }
}