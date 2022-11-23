package bridge.domain;

public class BridgeLength {

    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final String ERROR_BRIDGE_SIZE = String.format("다리 길이는 %d부터 %d 사이의 숫자여야 합니다.",
            MIN_BRIDGE_SIZE,
            MAX_BRIDGE_SIZE);

    private final int value;

    public BridgeLength(int value) {
        validateBridgeSize(value);
        this.value = value;
    }

    public int intValue() {
        return this.value;
    }

    private void validateBridgeSize(int size) {
        if (size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE);
        }
    }
}
