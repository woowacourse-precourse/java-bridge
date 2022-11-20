package bridge.domain;

import static bridge.domain.Constants.*;

public class BridgeState {

    private StringBuilder upBridge = new StringBuilder();
    private StringBuilder downBridge = new StringBuilder();

    public void mark(BridgeStatus bridgeStatus) {
        if (bridgeStatus.getStatus().equals(UP)) {
            upBridge.append(bridgeStatus.getStatus());
            downBridge.append(SPACE);
        } else if (bridgeStatus.getStatus().equals(DOWN)) {
            upBridge.append(SPACE);
            downBridge.append(bridgeStatus.getStatus());
        }
    }

    private boolean isEmpty() {
        return (upBridge.length() == 0 && downBridge.length() == 0);
    }

    public void initBridgeState() {
    }
}
