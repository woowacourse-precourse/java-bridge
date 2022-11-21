package bridge.domain.operator;

import java.util.ArrayList;
import java.util.List;

public class BridgeResult {

    private final List<String> upBridge;
    private final List<String> downBridge;


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


    public void addResult(boolean passable, int playerLocation, String playerSelection) {
        if (playerSelection.equals("U")) {
            upBridge.add(playerLocation, renderOX(passable));
            downBridge.add(playerLocation, "   ");
            return;
        }
        downBridge.add(playerLocation, renderOX(passable));
        upBridge.add(playerLocation, "   ");
    }

    public void resetBridgeResult() {
        upBridge.clear();
        downBridge.clear();
    }

    private String renderOX(boolean passable) {
        if (passable) {
            return " O ";
        }
        return " X ";
    }
}
