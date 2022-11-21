package bridge.domain;

public class User {
    private boolean isGameDoneStatus;
    private boolean isGameWin;
    private int gameTryCount;

    public User() {
        this.gameTryCount = 1;
        this.isGameDoneStatus = false;
        this.isGameWin = false;
    }

    public int getGameTryCount() {
        return gameTryCount;
    }

    public void gameRetry() {
        gameTryCount += 1;
    }

    public void gameDoneWithWin() {
        isGameDoneStatus = true;
        isGameWin = true;
    }

    public void gameDoneWithLose() {
        isGameDoneStatus = true;
        isGameWin = false;
    }

    public boolean isGameDoneStatus() {
        return isGameDoneStatus;
    }

    public boolean isGameWin() {
        return isGameWin;
    }
}
