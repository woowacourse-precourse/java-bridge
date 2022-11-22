package bridge.domain.vo;

import java.util.List;

public class BridgeMap {

    private final List<String> bridgeMap;

    private BridgeMap(List<String> bridgeMap) {
        this.bridgeMap = bridgeMap;
    }

    public static BridgeMap from(List<String> bridgeMap) {
        return new BridgeMap(bridgeMap);
    }

    public boolean isMovingCompare(PlayerMap playerMap, Moving moving) {
        return moving.equals(bridgeMap.get(playerMap.getSize()));
    }

    public boolean isCompareSize(PlayerMap playerMap) {
        return bridgeMap.size() == playerMap.getSize();
    }
}
