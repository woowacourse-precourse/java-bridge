package bridge.domain;

import bridge.controller.BridgeSetting;
import bridge.controller.BridgeStatus;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameMap {
    private final List<String> upSide;
    private final List<String> downSide;

    // UDD BRIDGE
    // UDU PLAYER
    // "O" / " " / "X"

    public BridgeGameMap() {
        upSide = new ArrayList<>();
        downSide = new ArrayList<>();
    }

    public void updateMap(String bridgeStatus, String playerMoving) {
        updateUpSide(bridgeStatus, playerMoving);
        updateDownSide(bridgeStatus, playerMoving);
    }
    private void updateUpSide(String bridgeStatus, String playerMoving) {
        BridgeStatus bridgeStatus1 = BridgeStatus.UP;
        if (playerMoving.equals(bridgeStatus1.getMoving())) {
            if (playerMoving.equals(bridgeStatus)) {
                upSide.add(BridgeSetting.CORRECT);
                return;
            }
            upSide.add(BridgeSetting.FALSE);
            return;
        }
        upSide.add(BridgeSetting.EMPTY);
    }

    private void updateDownSide(String bridgeStatus, String playerMoving) {
        BridgeStatus bridgeStatus1 = BridgeStatus.DOWN;
        if (playerMoving.equals(bridgeStatus1.getMoving())) {
            if (playerMoving.equals(bridgeStatus)) {
                downSide.add(BridgeSetting.CORRECT);
                return;
            }
            downSide.add(BridgeSetting.FALSE);
            return;
        }
        downSide.add(BridgeSetting.EMPTY);
    }

    public void reset() {
        upSide.clear();
        downSide.clear();
    }

    public List<String> getUpSide() {
        return upSide;
    }

    public List<String> getDownSide() {
        return downSide;
    }
}
