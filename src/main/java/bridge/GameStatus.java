package bridge;

public class GameStatus {
    private boolean isSuccess = false;
    private int tryCount = 0;

    public GameStatus(boolean isSuccess, int tryCount) {
        this.isSuccess = isSuccess;
        this.tryCount = tryCount;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public void addTryCount() {
        this.tryCount++;
    }
}
