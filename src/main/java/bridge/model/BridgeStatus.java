package bridge.model;

import bridge.constant.Game;

import java.util.*;

public class BridgeStatus {
    private static List<String> upBridgeStatus;
    private static List<String> downBridgeStatus;

    public void initBridgeStatus() {
        upBridgeStatus = new ArrayList<>();
        downBridgeStatus = new ArrayList<>();
    }
    public void addStatus(String movement, String status) {
        if(movement.equals(Game.BRIDGE_GENERATE_UP)) {
            upBridgeStatus.add(status);
            downBridgeStatus.add(Game.CROSS_NOT);
            return;
        }
        upBridgeStatus.add(Game.CROSS_NOT);
        downBridgeStatus.add(status);
    }
    public List<String> getUpBridgeStatus() {
        return upBridgeStatus;
    }
    public List<String> getDownBridgeStatus() {
        return downBridgeStatus;
    }
}
