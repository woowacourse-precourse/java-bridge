package bridge.domain.operator;

import java.util.ArrayList;
import java.util.List;

public class BridgeResult {

    private final List<Boolean> upBridge;
    private final List<Boolean> downBridge;

    public BridgeResult() {
        this.upBridge = new ArrayList<>();
        this.downBridge = new ArrayList<>();
    }

    public List<Boolean> getUpBridge() {
        return upBridge;
    }

    public List<Boolean> getDownBridge() {
        return downBridge;
    }

    public void addResult(boolean passable, int userLocation, String userSelection) {
        if (userSelection.equals("U")) {
            upBridge.add(userLocation, passable);
            downBridge.add(userLocation, null);
            return;
        }
        downBridge.add(userLocation, passable);
        upBridge.add(userLocation, null);
    }
}
