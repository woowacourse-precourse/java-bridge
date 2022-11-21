package bridge;

public class GameStatus {
    private boolean isEnd = false;
    private boolean isSuccess = false;
    private int tryCount = 1;


    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        if (success) {
            isEnd = true;
        }
        isSuccess = success;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void addTryCount() {
        this.tryCount++;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public static GameStatus startNewGame() {
        return new GameStatus();
    }
}
