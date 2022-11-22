package bridge;

public class Player {
    private int gameCount;
    private boolean GameClear;

    public Player() {
        this.gameCount = 1;
        this.GameClear = false;
    }

    public void addGameCount() {
        this.gameCount++;
    }

    public void setGameClear(boolean isClear) {
        this.GameClear = isClear;
    }
}
