package bridge.model.map;

import bridge.model.RoundStatus;
import bridge.model.bridge.BridgeDirection;
import java.util.StringJoiner;

public class Maps {

    private final Map upMap;
    private final Map downMap;

    public Maps(Map upMap, Map downMap) {
        this.upMap = upMap;
        this.downMap = downMap;
    }

    public static Maps byInitialState() {
        return new Maps(Map.create(), Map.create());
    }

    public void updateMaps(BridgeDirection bridgeDirection, RoundStatus roundStatus) {
        if (bridgeDirection == BridgeDirection.UP) {
            upMap.updateMap(roundStatus);
            downMap.updateMap(RoundStatus.ROUND_NONE);
        }
        if (bridgeDirection == BridgeDirection.DOWN) {
            upMap.updateMap(RoundStatus.ROUND_NONE);
            downMap.updateMap(roundStatus);
        }
    }

    @Override
    public String toString() {
        return new StringBuilder().append(upMap.getMap()).append("\n").append(downMap.getMap()).toString();
    }
}
