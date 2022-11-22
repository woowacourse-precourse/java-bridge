package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import static bridge.constant.BridgeConstant.BRIDGE_DOWN_COMMAND;
import static bridge.constant.BridgeConstant.BRIDGE_UP_COMMAND;

public class BridgeResult {
    private List<String> upperBridge = new ArrayList<>();
    private List<String> lowerBridge = new ArrayList<>();

    public void saveBridgeResult(String result, String moving) {
        if (moving.equals(BRIDGE_UP_COMMAND)) {
            upperBridge.add(result);
            lowerBridge.add(" ");
        }
        if (moving.equals(BRIDGE_DOWN_COMMAND)) {
            upperBridge.add(" ");
            lowerBridge.add(result);
        }
    }

    public List<String> getUpperBridge() {
        return upperBridge;
    }

    public List<String> getLowerBridge() {
        return lowerBridge;
    }
}
