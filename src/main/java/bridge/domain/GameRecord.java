package bridge.domain;

public class GameRecord {
    private int retryCount;

    public GameRecord() {
        this.retryCount = 0;
    }

    public void addRetryCount() {
        this.retryCount += 1;
    }

    public int getRetryCount() {
        return retryCount;
    }
}
