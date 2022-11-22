package bridge.domain;

public class BridgeGameRepository {

    private static final Integer ROUND_DEFAULT_VALUE = 1;
    private static final Integer TRY_COUNT_DEFAULT_VALUE = 1;

    private int round;
    private int tryCount;
    private int finalRound;

    public void init(int finalRound) {
        round = ROUND_DEFAULT_VALUE;
        tryCount = TRY_COUNT_DEFAULT_VALUE;
        this.finalRound = finalRound;
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


    public boolean isFinalRound() {
        return round == finalRound;
    }

    public void retry() {
        round = ROUND_DEFAULT_VALUE;
        tryCount++;
    }

}
