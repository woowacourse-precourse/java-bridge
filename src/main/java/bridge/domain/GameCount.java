package bridge.domain;

public class GameCount {
    private int gameCount = 1;

    public void increase() {
        this.gameCount++;
    }

    public int getGameCount() {
        return gameCount;
    }
}
