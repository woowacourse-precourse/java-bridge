package bridge.gamebridge;

import bridge.domain.Bridge;

public class PlayerBridge {

    private Bridge bridge;

    public Bridge getBridge() {
        return bridge;
    }

    public void setBridge(Bridge bridge) {
        this.bridge = bridge;
    }

    public boolean isEmpty() {
        return bridge == null;
    }

    public void clear() {
        this.bridge = null;
    }
}
