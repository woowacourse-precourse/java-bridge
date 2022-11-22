package bridge.domain;

public class BridgeGameRepository {

    private static final Integer ROUND_DEFAULT_VALUE = 1;
    private static final Integer TRY_COUNT_DEFAULT_VALUE = 1;

    private int round;
    private int tryCount;

    public BridgeGameRepository() {
        this.round = ROUND_DEFAULT_VALUE;
        this.tryCount = TRY_COUNT_DEFAULT_VALUE;
    }

    public int getRound() {
        return round;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void addOneToRound() {
        round++;
    }

    public void retry() {
        round = ROUND_DEFAULT_VALUE;
        tryCount++;
    }
}
