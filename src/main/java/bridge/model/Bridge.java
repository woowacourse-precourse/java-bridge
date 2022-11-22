package bridge.model;

import bridge.utils.BridgeStep;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<BridgeStep> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = new ArrayList<>();
        for (String step : bridge) {
            this.bridge.add(BridgeStep.findByString(step));
        }
    }

    public boolean isPassStep(int index, String playerMoving) {
        return bridge.get(index).equals(BridgeStep.findByString(playerMoving));
    }

    public int getBridgeSize() {
        return bridge.size();
    }
}
