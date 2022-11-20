package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeState {

    private final List<String> directions = new ArrayList<>();
    private final List<String> stateOfBridge = new ArrayList<>();

    public List<String> getDirections() {
        return directions;
    }

    public List<String> getStateOfBridge() {
        return stateOfBridge;
    }

    public void updateStateOfBridge(String direction, String resultOfMoving) {
        directions.add(direction);
        stateOfBridge.add(resultOfMoving);
    }

    public void clearAllBridgeState() {
        directions.clear();
        stateOfBridge.clear();
    }
}
