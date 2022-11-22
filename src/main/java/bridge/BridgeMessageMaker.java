package bridge;

import java.util.List;

import constants.*;

public class BridgeMessageMaker {
    BridgeMessage bridgeMessage;
    List<String> bridge;

    BridgeMessageMaker(List<String> bridge) {
        this.bridge = bridge;
    }

    public String makeBridgeMessage(String moving, int currentPosition) {
        this.bridgeMessage = new BridgeMessage();
        for (int i = 0; i < currentPosition; i++) {
            handlePreviousBridge(bridge.get(i));
        }
        handleNewBridge(moving, bridge.get(currentPosition));
        return bridgeMessage.get();
    }

    private void handlePreviousBridge(String currentBridgeStatus) {
        if (currentBridgeStatus.equals(Constants.UP)) {
            bridgeMessage.add(" O |", "   |");
            return;
        }
        bridgeMessage.add("   |", " O |");
    }

    private void handleNewBridge(String moving, String movingChecker) {
        String result = checkMoving(moving, movingChecker);
        if (moving.equals(Constants.UP)) {
            bridgeMessage.add(result, "   ]");
            return;
        }
        bridgeMessage.add("   ]", result);
    }

    private String checkMoving(String moving, String movingChecker) {
        if (moving.equals(movingChecker))
            return " O ]";
        return " X ]";
    }
}
