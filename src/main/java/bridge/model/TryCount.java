package bridge.model;

public class TryCount {
    private int tryCount;

    public TryCount() {
        tryCount = 1;
    }

    public void add() {
        tryCount++;
    }

    @Override
    public String toString() {
        return Integer.toString(tryCount);
    }
}
