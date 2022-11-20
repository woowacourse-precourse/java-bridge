package bridge.domain;

public class User {
    private int tryCount;
    private boolean isSuccessComplete;
    private boolean gameOver;

    public User(){
        this.tryCount = 1;
    }

    public int getTryCount() {
        return tryCount;
    }

    private void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public void increaseTryCount() {
        setTryCount(this.tryCount + 1);
    }

    public void winGame() {
        setSuccess();
    }

    private void setSuccess() {
        isSuccessComplete = true;
    }

    public boolean isSuccessComplete() {
        return isSuccessComplete;
    }

    public void finishGame() {
        setGameOver();
    }

    private void setGameOver() {
        gameOver = true;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
