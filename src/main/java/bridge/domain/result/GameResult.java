package bridge.domain.result;

public class GameResult {

    private int tryCnt;
    private boolean keepGoing;

    public GameResult(int tryCnt, boolean keepGoing) {
        this.tryCnt = tryCnt;
        this.keepGoing = keepGoing;
    }

    public int getTryCnt() {
        return tryCnt;
    }

    public boolean isKeepGoing() {
        return keepGoing;
    }

    public void gameOver() {
        this.keepGoing = false;
    }

    public void plusTryCnt() {
        tryCnt++;
    }
}
