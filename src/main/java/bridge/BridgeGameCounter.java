package bridge;

public class BridgeGameCounter {
    private final int countLimit;
    private int count = 0;

    public BridgeGameCounter(int limit) {
        countLimit = limit;
    }

    public void addCount() {
        count++;
    }

    public boolean isGameOver() {
        if (countLimit == count) {
            return true;
        }
        return false;
    }

    public void reset() {
        count = 0;
    }
}
