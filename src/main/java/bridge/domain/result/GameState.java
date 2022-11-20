package bridge.domain.result;

public class GameState {

    private int tryCnt;
    private boolean keepGoing;

    public GameState(int tryCnt, boolean keepGoing) {
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
