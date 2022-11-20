package bridge.domain.vo;

import java.util.List;

public class BridgeMap {
    private final List<String> bridgeMap;

    public BridgeMap(List<String> bridgeMap) {
        this.bridgeMap = bridgeMap;
    }

    public boolean isMove(PlayerMap playerMap, Moving moving) {
        return moving.equals(bridgeMap.get(playerMap.getSize()));
    }

    public int getSize() {
        return bridgeMap.size();
    }
}
