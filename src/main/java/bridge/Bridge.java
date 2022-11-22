package bridge;

import java.util.Collections;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        validateSize(bridge);
        validateElement(bridge);
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    private void validateSize(List<String> bridge) {
        if(bridge.size() < 3 || 20 < bridge.size()) {
            throw new IllegalArgumentException(ErrorMessage.NotValidBridgeSize.getMessage());
        }
    }

    private void validateElement(List<String> bridge) {
        if(Collections.frequency(bridge, "U") + Collections.frequency(bridge, "D") != bridge.size()) {
            throw new IllegalStateException(ErrorMessage.NotValidBridgeElement.getMessage());
        }
    }
}
