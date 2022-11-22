package bridge.model;

public class TryCount {
    private int tryCount;

    public TryCount() {
        tryCount = 1;
    }

    public void retry() {
        tryCount = tryCount + 1;
    }

    public int getTryCount() {
        return tryCount;
    }
}
