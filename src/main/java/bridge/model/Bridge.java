package bridge.model;

import bridge.model.constant.BridgeSpace;
import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> bridge = new ArrayList<>();

    public Bridge(List<String> bridge) {
        validateBridge(bridge);
        this.bridge.addAll(bridge);
    }

    public List<String> getBridge() {
        return bridge;
    }

    private void validateBridge(List<String> bridge) {
        for (String space : bridge) {
            if (!space.equals(BridgeSpace.UP.getValue()) && !space.equals(BridgeSpace.DOWN.getValue())) {
                throw new IllegalStateException();
            }
        }
    }
}
