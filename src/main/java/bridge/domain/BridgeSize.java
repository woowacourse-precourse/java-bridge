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
        validBridgeSizeRange(Long.parseLong(bridgeSize));
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

    private void validBridgeSizeRange(long bridgeSize) {
        if (bridgeSize < Constant.BRIDGE_SIZE_MIN || bridgeSize > Constant.BRIDGE_SIZE_MAX) {
            throw new IllegalArgumentException(ErrorMessage.NOT_BRIDGE_SIZE_RANGE.getMessage());
        }
    }
}
