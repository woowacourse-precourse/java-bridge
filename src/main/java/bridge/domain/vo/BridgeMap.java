package bridge.domain.vo;

import java.util.List;

public class BridgeMap {
    private final List<String> bridgeMap;

    public BridgeMap(List<String> bridgeMap) {
        this.bridgeMap = bridgeMap;
    }

    public boolean checkMapWithIndex(int index, String moving) {
        return bridgeMap.get(index).equals(moving);
    }

    public int getSize() {
        return bridgeMap.size();
    }
}
