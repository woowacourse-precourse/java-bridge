package bridge.domain;

import java.util.List;

public class Bridge {

    private List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public String getNow(BridgeGameManager bridgeGameManager) {
        return bridge.get(bridgeGameManager.getStep());
    }

    public int getSize() {
        return bridge.size();
    }
}
