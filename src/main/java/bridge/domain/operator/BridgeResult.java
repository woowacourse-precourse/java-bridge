package bridge.domain.operator;

import java.util.ArrayList;
import java.util.List;

public class BridgeResult {

    private final List<String> upBridge;
    private final List<String> downBridge;

    private int attempt;

    public BridgeResult() {
        this.upBridge = new ArrayList<>();
        this.downBridge = new ArrayList<>();
    }

    public List<String> getUpBridge() {
        return upBridge;
    }

    public List<String> getDownBridge() {
        return downBridge;
    }

    public int getAttempt() {
        return attempt;
    }

    public void addResult(boolean passable, int userLocation, String userSelection) {
        if (userSelection.equals("U")) {
            upBridge.add(userLocation, renderOX(passable));
            downBridge.add(userLocation, "   ");
            return;
        }
        downBridge.add(userLocation, renderOX(passable));
        upBridge.add(userLocation, "   ");
    }

    public void plusAttempt() {
        attempt++;
    }

    private String renderOX(boolean passable) {
        if (passable) {
            return " O ";
        }
        return " X ";
    }
}
