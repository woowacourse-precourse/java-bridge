package bridge.domain;

public class BridgeSizeValidator {

    private final int bridgeSize;

    public BridgeSizeValidator(int bridgeSize) {
        validateBridgeSize(bridgeSize);
        this.bridgeSize = bridgeSize;
    }

    public int bridgeSize() {
        return bridgeSize;
    }

    private void validateBridgeSize(int size) {
        final int MIN_SIZE = 3;
        final int MAX_SIZE = 20;
        if (size < MIN_SIZE || MAX_SIZE < size) {
            throw new IllegalArgumentException("다리의 길이는 3 이상 20 이하여야 합니다.");
        }
    }
}
