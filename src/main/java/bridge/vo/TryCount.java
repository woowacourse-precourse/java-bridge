package bridge.vo;

public class TryCount {
    private int tryCount;

    public TryCount() {
        tryCount = 0;
    }

    public void addCount() {
        tryCount++;
    }

    @Override
    public String toString() {
        return Integer.toString(tryCount);
    }
}
