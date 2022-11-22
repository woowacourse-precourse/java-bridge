package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int bridgeNumber = bridgeNumberGenerator.generate();
            addBridge(bridge, bridgeNumber);
        }
        return bridge;
    }
    private void addBridge(List<String> bridge, int bridgeNumber) {
        for (BridgeState bridgeState : BridgeState.values()) {
            if (bridgeState.getBridgeNumber() == bridgeNumber) {
                bridge.add(bridgeState.getBridgeMark());
            }
        }
    }
}
