package bridge.domain;

import bridge.constants.Command;
import java.util.ArrayList;
import java.util.List;

public class BridgeState {
    private static final String SPACE = " ";

    private final List<String> upBridge = new ArrayList<>();
    private final List<String> downBridge = new ArrayList<>();

    public void addBridge(String playerMoving, String bridgeJudgment) {
        if (playerMoving.equals(Command.UP.relevantCommand())) {
            upBridge.add(bridgeJudgment);
            downBridge.add(SPACE);
            return;
        }

        upBridge.add(SPACE);
        downBridge.add(bridgeJudgment);
    }

    public String upBridgeGenerate() {
        return "[ " + String.join(" | ", upBridge) + " ]";
    }

    public String downBridgeGenerate() {
        return "[ " + String.join(" | ", downBridge) + " ]";
    }

    public void reset() {
        upBridge.clear();
        downBridge.clear();
    }
}