package bridge.constant;

public enum BridgeSizeRule {
    MINIMUM_SIZE(3),
    MAXIMUM_SIZE(20);

    public final Integer size;

    BridgeSizeRule(Integer size) {
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }

    public static void validateBridgeSize(Integer bridgeSize) {
        if (!(MINIMUM_SIZE.size <= bridgeSize && bridgeSize <= MAXIMUM_SIZE.size)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_MUST_BE_FROM_THREE_TO_TWENTY.getMessage());
        }
    }
}
