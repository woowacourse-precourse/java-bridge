package bridge.game;

import bridge.map.Map;

import java.util.List;

public class BridgeGame {

    private final List<String> bridge;
    private int currentPosition;
    private int totalTry;
    private Map map;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        currentPosition = 0;
        totalTry = 1;
        map = new Map();
    }

    public int getTotalTry() {
        return totalTry;
    }

    public Map getMap() {
        return map;
    }

    public int move(String moving) {
        if (canMove(moving)) {
            if (currentPosition == bridge.size() - 1) {
                return Status.SUCCESS.getNumber();
            }
            currentPosition++;
            return Status.CONTINUE.getNumber();
        }
        return Status.FAIL.getNumber();
    }

    private boolean canMove(String moving) {
        String bridgeStatus = bridge.get(currentPosition);
        if (bridgeStatus.equals(moving)) {
            map.addCanCross(moving);
            return true;
        }
        map.addCanNotCross(moving);
        return false;
    }

    public void retry() {
        currentPosition = 0;
        totalTry++;
        map = new Map();
    }
}
