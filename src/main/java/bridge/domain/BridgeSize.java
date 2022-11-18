package bridge.domain;

public class BridgeSize {

    static final String NOT_VALID_RANGE_OF_BRIDGE_SIZE = "다리의 길이는 3 이상 20 이하여야 합니다.";

    private final int bridgeSize;

    public BridgeSize(int bridgeSize) {
        validateBridgeSize(bridgeSize);
        this.bridgeSize = bridgeSize;
    }

    boolean isMoreThan(int position) {
        return position < bridgeSize;
    }

    public int bridgeSize() {
        return bridgeSize;
    }

    private void validateBridgeSize(int size) {
        final int MIN_SIZE = 3;
        final int MAX_SIZE = 20;
        if (size < MIN_SIZE || MAX_SIZE < size) {
            throw new IllegalArgumentException(NOT_VALID_RANGE_OF_BRIDGE_SIZE);
        }
    }
}
