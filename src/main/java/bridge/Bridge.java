package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    private String getCorrectPosition(int bridgePosition) {
        return this.bridge.get(bridgePosition);
    }

    public boolean moveCheck(String userPosition, BridgeGame bridgeGame) {
        return getCorrectPosition(bridgeGame.getBridgePosition()).equals(userPosition);
    }

    public String getLastBridge() {
        return this.bridge.get(this.bridge.size() - 1);
    }
}

