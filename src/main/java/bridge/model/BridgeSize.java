package bridge.model;

import bridge.view.Message;

public class BridgeSize {
    private final int bridgeSize;
    public static final int LOWER_BRIDGE_SIZE = 3;
    public static final int UPPER_BRIDGE_SIZE = 20;

    public BridgeSize(String bridgeSize) {

        validateNotNull(bridgeSize);
        validateNumber(bridgeSize);
        validateRange(Integer.parseInt(bridgeSize));

        this.bridgeSize = Integer.parseInt(bridgeSize);
    }

    private void validateNotNull(String bridgeSize) {
        if (bridgeSize == null || "".equals(bridgeSize)) {
            throw new IllegalArgumentException(Message.ERROR + Message.BRIDGE_SIZE_ERROR);
        }
    }

    private void validateNumber(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR + Message.BRIDGE_SIZE_ERROR);
        }
    }

    private void validateRange(int bridgeSize) {
        if (bridgeSize < LOWER_BRIDGE_SIZE || bridgeSize > UPPER_BRIDGE_SIZE) {
            throw new IllegalArgumentException(Message.ERROR + Message.BRIDGE_SIZE_ERROR);
        }
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
