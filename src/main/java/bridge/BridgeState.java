package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeState {

    private final List<String> rightDirectionsOfBridge = new ArrayList<>();
    private final List<String> markingsOfUserMoving = new ArrayList<>();

    public List<String> getRightDirectionsOfBridge() {
        return rightDirectionsOfBridge;
    }

    public List<String> getMarkingsOfUserMoving() {
        return markingsOfUserMoving;
    }

    public void updateStateOfBridge(String direction, String resultOfMoving) {
        rightDirectionsOfBridge.add(direction);
        markingsOfUserMoving.add(resultOfMoving);
    }

    public void clearAllBridgeState() {
        rightDirectionsOfBridge.clear();
        markingsOfUserMoving.clear();
    }
}
