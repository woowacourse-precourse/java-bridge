package bridge.domain;

public class User {
    private static final int DEFAULT_VALUE = 1;
    private static final int ADD_RETRY_COUNT = 1;
    private int tryCount;
    private boolean isSuccessComplete;
    private boolean gameOver;

    public User() {
        this.tryCount = DEFAULT_VALUE;
    }

    public int getTryCount() {
        return tryCount;
    }

    private void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public void increaseTryCount() {
        setTryCount(this.tryCount + ADD_RETRY_COUNT);
    }


    private void setSuccess() {
        isSuccessComplete = true;
    }

    public boolean isSuccessComplete() {
        return isSuccessComplete;
    }

    private void setGameOver() {
        gameOver = true;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void finishWithWin() {
        setSuccess();
        setGameOver();
    }

    public void finishWithFail() {
        setGameOver();
    }
}
