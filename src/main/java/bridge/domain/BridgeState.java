package bridge.domain;

import static bridge.domain.Constants.*;

public class BridgeState {

    private StringBuilder upBridge = new StringBuilder();
    private StringBuilder downBridge = new StringBuilder();

    public void mark(BridgeStatus bridgeStatus) {
        if (bridgeStatus.getArrow().equals(UP)) {
            if (isEmpty()) {
                upBridge.append(bridgeStatus.getStatus());
                downBridge.append(SPACE);
                return;
            }
            upBridge.append(DELIMITER).append(bridgeStatus.getStatus());
            downBridge.append(DELIMITER).append(SPACE);
            return;
        }

        if (bridgeStatus.getArrow().equals(DOWN)) {
            if (isEmpty()) {
                upBridge.append(SPACE);
                downBridge.append(bridgeStatus.getStatus());
                return;
            }
            upBridge.append(DELIMITER).append(SPACE);
            downBridge.append(DELIMITER).append(bridgeStatus.getStatus());
        }
    }

    private boolean isEmpty() {
        return (upBridge.length() == BRIDGE_LENGTH_INIT && downBridge.length() == BRIDGE_LENGTH_INIT);
    }

    public void initBridgeState() {
        upBridge = new StringBuilder();
        downBridge = new StringBuilder();
    }

    public String getUpBridgeState() {
        return upBridge.toString();
    }

    public String getDownBridgeState() {
        return downBridge.toString();
    }
}
