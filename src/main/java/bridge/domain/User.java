package bridge.domain;

public class User {
    private boolean isGameDoneStatus;
    private int gameTryCount;

    public boolean isGameDoneStatus() {
        return isGameDoneStatus;
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
