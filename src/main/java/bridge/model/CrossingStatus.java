package bridge.model;

import bridge.constant.BridgeStatus;
import bridge.constant.Game;

import java.util.ArrayList;
import java.util.List;

public class CrossingStatus {
    private static List<String> upBridgeStatus;
    private static List<String> downBridgeStatus;

    public void initBridgeStatus() {
        upBridgeStatus = new ArrayList<>();
        downBridgeStatus = new ArrayList<>();
    }
    public void addStatus(String movement, String status) {
        if(movement.equals(BridgeStatus.UP.getStatus())) {
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
