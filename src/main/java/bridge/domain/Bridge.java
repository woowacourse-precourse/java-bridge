package bridge.domain;

import bridge.domain.SafeSpot;
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
        bridgePosition += 1;
    }

    public boolean isLastStep() {
        return bridgePosition == baseBridge.size() ;
    }

    public boolean isSafe(String moveTo) {
        return baseBridge.get(bridgePosition).equals(moveTo);
    }
}
