package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<BridgeLane> safeLaneMap;

    public Bridge(List<String> safeLaneInfo) {
        safeLaneMap = new ArrayList<>();
        for(String spotInfoText : safeLaneInfo) {
            safeLaneMap.add(BridgeLane.makeBridgeLane(spotInfoText));
        }
    }

    public int getBridgeSize() {
        return safeLaneMap.size();
    }

    public boolean isSafeSpot(int position, BridgeLane bridgeLane) {
        BridgeLane safeLaneAtPosition = safeLaneMap.get(position - 1);
        return safeLaneAtPosition.equals(bridgeLane);
    }
}
