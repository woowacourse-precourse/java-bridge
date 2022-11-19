package bridge.domain.bridgegame;

public class AttemptCount {
    private final int attemptCount;

    private AttemptCount(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    public static AttemptCount from(int attemptCount) {
        return new AttemptCount(attemptCount);
    }

    public AttemptCount increaseCount() {
        return new AttemptCount(attemptCount + 1);
    }

    public int toInt() {
        return attemptCount;
    }

    @Override
    public String toString() {
        return Integer.toString(attemptCount);
    }
}

