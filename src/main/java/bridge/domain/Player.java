package bridge.domain;

public class Player {
    private int gameCount;
    private boolean gameClear;

    public Player() {
        this.gameCount = 1;
        this.gameClear = false;
    }

    public int getGameCount() {
        return gameCount;
    }

    public void addGameCount() {
        this.gameCount++;
    }

    public boolean isGameClear() {
        return gameClear;
    }
    public void setGameClear(boolean isClear) {
        this.gameClear = isClear;
    }
}
