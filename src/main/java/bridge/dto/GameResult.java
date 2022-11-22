package bridge.dto;

public class GameResult {

    private final int tryCount;
    private final boolean gameClear;

    public GameResult(int tryCount, boolean gameClear) {
        this.tryCount = tryCount;
        this.gameClear = gameClear;
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean isGameClear() {
        return gameClear;
    }
}
