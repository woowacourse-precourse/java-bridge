package bridge.model;

import java.util.List;

public class BridgeComparator {

    private static final String BRIDGE_CORRECT = "O";
    private static final String BRIDGE_FAIL = "X";
    private static final int INDEX_PLUS = 1;

    public String compareBridge(List<String> bridge, String moving, int location) {
        if (bridge.get(location).equals(moving)) {
            return BRIDGE_CORRECT;
        }
        return BRIDGE_FAIL;
    }

    public boolean isExpressionX(int location, List<List<String>> bridgeMap) {
        if (isBridgeMapLocationContainX(location, bridgeMap.get(0))) return true;
        if (isBridgeMapLocationContainX(location, bridgeMap.get(1))) return true;
        return false;
    }

    private boolean isBridgeMapLocationContainX(int location, List<String> bridgeUpMap) {
        if (bridgeUpMap.get(location).equals(BRIDGE_FAIL)) {
            return true;
        }
        return false;
    }

    public boolean isEndPoint(List<String> bridge, int location) {
        if (bridge.size() == location + INDEX_PLUS) {
            return true;
        }
        return false;
    }

}
