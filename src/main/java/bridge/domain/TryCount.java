package bridge.domain;

public class TryCount {

    private int tryCount = 1;

    public void updateTryCount() {
        tryCount++;
    }

    @Override
    public String toString() {
        return Integer.toString(tryCount);
    }
}
