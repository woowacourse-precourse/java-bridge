package bridge.domain;

import bridge.domain.SafeSpot;
import java.util.List;

public class Bridge {

    private int bridgePosition;
    private SafeSpot safeSpot;

    private final List<String> baseBridge;

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
