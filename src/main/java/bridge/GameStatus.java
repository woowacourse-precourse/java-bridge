package bridge;

public class GameStatus {
    private boolean isEnd;
    private int gameCount;
    private boolean gameClear;

    public GameStatus() {
        this.isEnd = false;
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

    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }
    public boolean getEnd() {
        return this.isEnd;
    }
}
