package bridge.domain.vo;

import java.util.List;

public class BridgeMap {
    private final List<String> bridgeMap;

    public BridgeMap(List<String> bridgeMap) {
        this.bridgeMap = bridgeMap;
    }

    public boolean isEqualWithIndex(int index, Moving moving) {
        return moving.equals(bridgeMap.get(index));
    }

    public int getSize() {
        return bridgeMap.size();
    }
}
