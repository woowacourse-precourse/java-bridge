package bridge.domain.bridgeGame.gameStatus.gameStatics;

public class AttemptCount {
    private final static int INIT_ATTEMPT_COUNT = 1;
    private final int attemptCount;

    private AttemptCount(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    public static AttemptCount initCount() {
        return new AttemptCount(INIT_ATTEMPT_COUNT);
    }

    public AttemptCount increaseCount() {
        return new AttemptCount(attemptCount + 1);
    }

    @Override
    public String toString() {
        return Integer.toString(attemptCount);
    }
}

