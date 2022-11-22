package bridge.game;

import bridge.map.Map;

import java.util.List;

public class BridgeGame {

    private final List<String> bridge;
    private int indexOfDestination;
    private int totalTry;
    private Map map;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        indexOfDestination = 0;
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
        if (isCrossable(moving)) {
            map.addCrossing(moving);
            return isEndOfBridge();
        }

        map.addNoCrossing(moving);
        return Status.FAIL.getNumber();
    }

    public void retry() {
        indexOfDestination = 0;
        totalTry++;
        map = new Map();
    }

    private boolean isCrossable(String moving) {
        String destinationStatus = bridge.get(indexOfDestination);
        return destinationStatus.equals(moving);
    }

    private int isEndOfBridge() {
        if (indexOfDestination == bridge.size() - 1) {
            return Status.SUCCESS.getNumber();
        }

        indexOfDestination++;
        return Status.CONTINUE.getNumber();
    }
}
