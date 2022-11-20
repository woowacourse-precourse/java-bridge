package bridge.domain;

public class User {
    private int tryCount = 1;
    private boolean isSuccess;
    private boolean gameOver;

    public int getTryCount() {
        return tryCount;
    }

    private void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public void increaseTryCount() {
        setTryCount(this.tryCount + 1);
    }

    public void setSuccess() {
        isSuccess = true;
    }

    public boolean isSuccessComplete() {
        return isSuccess;
    }

    public void setGameOver() {
        gameOver = true;
    }
    public boolean isGameOver() {
        return gameOver;
    }
}
