package bridge.domain;

public class GameResult {
    private boolean success;
    private int tryCount;

    public GameResult(boolean success, int tryCount) {
        this.success = success;
        this.tryCount = tryCount;
    }

    public Boolean getSuccess() {
        return success;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void plusTryCount() {
        tryCount++;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
