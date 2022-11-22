package bridge.domain;

import static bridge.util.Constant.*;
import static bridge.util.Validator.validateMovingInput;

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
        bridgePosition += ONESTEP;
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

    public void addSafe(String moveTo) {
        validateMovingInput(moveTo);
        if (moveTo.equals(UPLOCATION)) {
            upperBridge.add(CORRECTSPOT);
            lowerBridge.add(NOSPOT);
            return;
        }
        if (moveTo.equals(DOWNLOCATION)) {
            upperBridge.add(NOSPOT);
            lowerBridge.add(CORRECTSPOT);
        }
    }

    public void addUnSafe(String moveTo) {
        validateMovingInput(moveTo);
        if (moveTo.equals(UPLOCATION)) {
            upperBridge.add(UNCORRECTSPOT);
            lowerBridge.add(NOSPOT);
            return;
        }
        if (moveTo.equals(DOWNLOCATION)) {
            upperBridge.add(NOSPOT);
            lowerBridge.add(UNCORRECTSPOT);
        }
    }

    public void removeUnsafeSpot() {
        upperBridge.remove(upperBridge.size() - ONESTEP);
        lowerBridge.remove(lowerBridge.size() - ONESTEP);
    }

    public List<String> getBaseBridge() {
        return baseBridge;
    }

    public List<String> getUpperBridge() {
        return upperBridge;
    }

    public List<String> getLowerBridge() {
        return lowerBridge;
    }
    public int getBridgePosition() {
        return bridgePosition;
    }
}
