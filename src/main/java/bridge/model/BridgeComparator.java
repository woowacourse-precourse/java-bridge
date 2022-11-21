package bridge.model;

import java.util.List;

public class BridgeComparator {

    private static final String BRIDGE_CORRECT = "O";
    private static final String BRIDGE_FAIL="X";

    public String compareBridge(List<String> bridge, String moving, int location) {
        if (bridge.get(location).equals(moving)) {
            return BRIDGE_CORRECT;
        }
        return BRIDGE_FAIL;
    }

    public boolean isExpressionX(int location, List<String> bridgeUpMap, List<String> bridgeDownMap) {
        if (isBridgeMapLocationContainX(location, bridgeUpMap)) return true;
        if (isBridgeMapLocationContainX(location, bridgeDownMap)) return true;
        return false;
    }

    private static boolean isBridgeMapLocationContainX(int location, List<String> bridgeUpMap) {
        if (bridgeUpMap.get(location).equals(BRIDGE_FAIL)) {
            return true;
        }
        return false;
    }
}
