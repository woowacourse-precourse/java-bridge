package bridge.domain.bridgegame;

public class AttemptCount {
    private final static AttemptCount ATTEMPT_COUNT = new AttemptCount();
    private int count;

    private AttemptCount() {
        this.count = 0;
    }

    public static AttemptCount getInstance() {
        return ATTEMPT_COUNT;
    }

    public void add() {
        count++;
    }

    @Override
    public String toString() {
        return Integer.toString(count);
    }
}

