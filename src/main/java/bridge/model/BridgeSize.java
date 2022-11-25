package bridge.model;

import bridge.constant.Bridge;
import bridge.constant.ErrorMessage;

public class BridgeSize {

    private final int bridgeSize;

    public BridgeSize(String bridgeSize) {
        validate(bridgeSize);
        this.bridgeSize = Integer.parseInt(bridgeSize);
    }

    private void validate(String bridgeSize) {
        if (!validateType(bridgeSize)) {
            throw new IllegalArgumentException(ErrorMessage.SIZE_TYPE.getMessage());
        }
        if (!validateRange(Integer.parseInt(bridgeSize))) {
            throw new IllegalArgumentException(ErrorMessage.SIZE_RANGE.getMessage());
        }
    }

    private boolean validateType(String bridgeSize) {
        return bridgeSize.matches("^[0-9]*$");
    }

    private boolean validateRange(int bridgeSize) {
        return bridgeSize >= Bridge.MIN.getNumber() && bridgeSize <= Bridge.MAX.getNumber();
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
