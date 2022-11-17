package bridge;

public class FinalMessage {

    private int tryCount;
    private boolean gameClear;

    public FinalMessage(int tryCount, boolean gameClear) {
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
