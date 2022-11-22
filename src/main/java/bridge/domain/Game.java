package bridge.domain;

public class Game {
    private int tryCount;

    public Game(int tryCount) {
        this.tryCount = tryCount;
    }

    public void increaseTryCount() {
        this.tryCount++;
    }

    public int getTryCount() {
        return tryCount;
    }
}
