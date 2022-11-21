package bridge.domain;

import static bridge.constant.BridgeConstant.BRIDGE_LENGTH_MAXIMUM;
import static bridge.constant.BridgeConstant.BRIDGE_LENGTH_MINIMUM;

import bridge.type.ErrorType;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        validateBridgeSize(bridge.size());
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    private void validateBridgeSize(int size) throws IllegalArgumentException {
        if (size < BRIDGE_LENGTH_MINIMUM || size > BRIDGE_LENGTH_MAXIMUM) {
            throw new IllegalArgumentException(ErrorType.BRIDGE_SIZE_ERROR.printError());
        }
    }
}
