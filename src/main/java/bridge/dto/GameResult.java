package bridge.dto;

public class GameResult {

    private int tryCount;
    private boolean gameClear;

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
