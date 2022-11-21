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

    public void addSafe(String moveTo) {
        Validator.validateMovingInput(moveTo);
        if (moveTo.equals(Constant.UP)) {
            upperBridge.add(Constant.CORRECTSPOT);
            lowerBridge.add(Constant.NOSPOT);
            return;
        }
        if (moveTo.equals(Constant.DOWN)) {
            upperBridge.add(Constant.NOSPOT);
            lowerBridge.add(Constant.CORRECTSPOT);
        }
    }

    public void addUnSafe(String moveTo) {
        Validator.validateMovingInput(moveTo);
        if (moveTo.equals(Constant.UP)) {
            upperBridge.add(Constant.UNCORRECTSPOT);
            lowerBridge.add(Constant.NOSPOT);
            return;
        }
        if (moveTo.equals(Constant.DOWN)) {
            upperBridge.add(Constant.NOSPOT);
            lowerBridge.add(Constant.UNCORRECTSPOT);
        }
    }

    public void removeUnsafeSpot() {
        upperBridge.remove(upperBridge.size() - Constant.ONESTEP);
        lowerBridge.remove(lowerBridge.size() - Constant.ONESTEP);
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
}
