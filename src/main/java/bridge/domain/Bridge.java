package bridge.domain;

import bridge.util.Constant;
import bridge.util.Validator;
import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private int bridgePosition;

    private final List<String> baseBridge;
    private List<String> upperBridge = new ArrayList<>();
    private List<String> lowerBridge = new ArrayList<>();

    public Bridge(int bridgePosition, List<String> baseBridge) {
        this.bridgePosition = bridgePosition;
        this.baseBridge = baseBridge;
    }

    public void step() {
        bridgePosition += Constant.ONESTEP;
    }

    public boolean isLastStep() {
        return bridgePosition == baseBridge.size();
    }


    public void addResult(String moveto) {
        if (isSafe(moveto)) {
            addSafe(moveto);
            return;
        }
        addUnSafe(moveto);

    }

    public boolean isSafe(String moveTo) {
        return baseBridge.get(bridgePosition).equals(moveTo);
    }
}
