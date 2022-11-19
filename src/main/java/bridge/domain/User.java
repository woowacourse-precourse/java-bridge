package bridge.domain;

public class User {
    private int tryCount = 1;
    private boolean isSuccess;
    private boolean gameOver;

    public int getTryCount() {
        return tryCount;
    }

    public void increaseTryCount() {
        tryCount++;
    }
    public void setSuccess(){
        isSuccess = true;
    }

    public boolean isSuccessComplete(){
        return isSuccess;
    }

    public void setGameOver(){
        gameOver = true;
    }
}
