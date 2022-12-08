package bridge.model.map;

import bridge.model.bridge.BridgeDirection;
import bridge.model.status.RoundStatus;

public class Maps {

    private final Map upMap;
    private final Map downMap;

    private Maps(Map upMap, Map downMap) {
        this.upMap = upMap;
        this.downMap = downMap;
    }


    public static Maps byInitialState() {
        return new Maps(Map.create(), Map.create());
    }

    public void updateMaps(BridgeDirection bridgeDirection, RoundStatus roundStatus) {
        if (bridgeDirection.isSame(BridgeDirection.UP)) {
            upMap.updateMap(roundStatus);
            downMap.updateMap(RoundStatus.ROUND_NONE);
        }
        if (bridgeDirection.isSame(BridgeDirection.DOWN)) {
            upMap.updateMap(RoundStatus.ROUND_NONE);
            downMap.updateMap(roundStatus);
        }
    }

    @Override
    public String toString() {
        return new StringBuilder().append(upMap.getMap()).append("\n").append(downMap.getMap()).toString();
    }
}
