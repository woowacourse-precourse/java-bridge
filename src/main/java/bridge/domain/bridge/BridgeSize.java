package bridge.domain.bridge;

public class BridgeSize {

    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;

    private final int size;

    public BridgeSize(int size) {
        validateSize(size);
        this.size = size;
    }

    private void validateSize(int size) {
        if (size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public int getSize() {
        return size;
    }
}

