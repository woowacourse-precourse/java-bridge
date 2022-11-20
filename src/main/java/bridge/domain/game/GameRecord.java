package bridge.domain.game;

public class GameRecord {
    private int retryCount;

    public GameRecord() {
        this.retryCount = 1;
    }

    public void addRetryCount() {
        this.retryCount += 1;
    }

    public int getRetryCount() {
        return retryCount;
    }
}
