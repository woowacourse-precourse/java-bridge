package bridge.domain;

public class User {
    private boolean isGameDoneStatus;
    private boolean isGameSuccess;
    private int gameTryCount;

    public User() {
        this.gameTryCount = 1;
        this.isGameDoneStatus = false;
        this.isGameSuccess = false;
    }

    public boolean isGameSuccess() {
        return this.isGameSuccess;
    }

    public void setGameSuccess(boolean gameSuccess) {
        isGameSuccess = gameSuccess;
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
