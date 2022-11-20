package bridge.domain;

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
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(ErrorType.BRIDGE_SIZE_ERROR.printError());
        }
    }
}
