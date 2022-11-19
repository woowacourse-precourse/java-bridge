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

    public boolean isGameWin() {
        return this.isGameWin;
    }

    public void setGameSuccess(boolean gameSuccess) {
        isGameWin = gameSuccess;
    }

    public void gameSuccess() {
        setGameSuccess(true);
    }

    public void gameFail() {
        setGameSuccess(false);
    }

    public boolean isGameDoneStatus() {
        return this.isGameDoneStatus;
    }

    public void setGameDoneStatus(boolean gameDoneStatus) {
        isGameDoneStatus = gameDoneStatus;
    }

    public void gameDoneSuccess() {
        setGameDoneStatus(true);
    }

    public int getGameTryCount() {
        return gameTryCount;
    }

    public void setGameTryCount(int gameTryCount) {
        this.gameTryCount = gameTryCount;
    }

    public void gameRetry() {
        setGameTryCount(this.getGameTryCount() + 1);
    }
}
