package bridge.domain;

import bridge.constant.Constant;
import bridge.constant.ErrorMessage;

public class BridgeSize {
    private final int bridgeSize;

    public BridgeSize(String bridgeSize) {
        validBridgeSize(bridgeSize);
        this.bridgeSize = Integer.parseInt(bridgeSize);
    }

    public int getSize() {
        return bridgeSize;
    }

    private void validBridgeSize(String bridgeSize) {
        validIsEmpty(bridgeSize);
        validIsDigit(bridgeSize);
        validBridgeSizeRange(bridgeSize);
    }

    private void validIsEmpty(String bridgeSize) {
        if (bridgeSize.length() == Constant.EMPTY_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NO_INPUT_VALUE.getMessage());
        }
    }

    private void validIsDigit(String bridgeSize) {
        if (!bridgeSize.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    private void validBridgeSizeRange(String bridgeSize) {
        long size = convertToNumber(bridgeSize);
        if (size < Constant.BRIDGE_SIZE_MIN || size > Constant.BRIDGE_SIZE_MAX) {
            throw new IllegalArgumentException(ErrorMessage.NOT_BRIDGE_SIZE_RANGE.getMessage());
        }
    }

    private long convertToNumber(String bridgeSize) {
        try {
            return Long.parseLong(bridgeSize);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_BRIDGE_SIZE_RANGE.getMessage());
        }
    }
}
