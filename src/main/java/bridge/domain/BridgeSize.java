package bridge.domain;

public class BridgeSize {
    private final String ERROR_TYPE_MESSAGE = "[ERROR] 다리 길이는 숫자이어야 합니다.";
    private final String ERROR_RANGE_MESSAGE = "[ERROR] 다리 길이는 3~20 사이의 숫자이어야 합니다.";

    private final int bridgeSize;

    public BridgeSize(String bridgeSize) {
        validate(bridgeSize);
        this.bridgeSize = Integer.parseInt(bridgeSize);
    }

    private void validate(String bridgeSize) {
        if (!validateType(bridgeSize)) {
            throw new IllegalArgumentException(ERROR_TYPE_MESSAGE);
        }
        if (!validateRange(Integer.parseInt(bridgeSize))) {
            throw new IllegalArgumentException(ERROR_RANGE_MESSAGE);
        }
    }

    private boolean validateType(String bridgeSize) {
        return bridgeSize.matches("^[0-9]*$");
    }

    private boolean validateRange(int bridgeSize) {
        return bridgeSize >= 3 && bridgeSize <= 20;
    }
}
