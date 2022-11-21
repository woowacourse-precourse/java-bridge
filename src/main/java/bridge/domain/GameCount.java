package bridge.domain;

public class GameCount {
    private static final int START_COUNT = 1;
    private int gameCount;

    public GameCount(int gameCount) {
        this.gameCount = gameCount;
    }

    public static GameCount start() {
        return new GameCount(START_COUNT);
    }

    public void increase() {
        this.gameCount++;
    }

    public int count() {
        return gameCount;
    }
}
