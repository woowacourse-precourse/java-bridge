package bridge.domain;

public class BridgeSize {
    private int size;
    private static int MIN_BRIDGE_SIZE = 3;
    private static int MAX_BRIDGE_SIZE = 20;

    public BridgeSize(int size) {
        checkSizeIsInRange(size);
        this.size = size;
    }

    private void checkSizeIsInRange(int size) {
        if (size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException("다리의 길이는 3부터 20 사이의 숫자여야 합니다. ");
        }
    }

    public int getSize() {
        return this.size;
    }
}
