package bridge.repository;

public class TryRepository {

    public static final int INITIAL_TRY_VALUE = 1;

    private int totalTries;

    public TryRepository() {
        this.totalTries = INITIAL_TRY_VALUE;
    }

    public void increase() {
        this.totalTries++;
    }

    public int getTotalTries() {
        return this.totalTries;
    }
}
