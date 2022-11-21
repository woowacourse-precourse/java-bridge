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
        int bridgeNumber;
        for (int i = 0; i < size; i++) {
            bridgeNumber = bridgeNumberGenerator.generate();
            makeEachBridge(bridge, bridgeNumber);
        }
        return bridge;
    }

    private void makeEachBridge(List<String> bridge, int bridgeNumber) {
        if (bridgeNumber == 0) {
            bridge.add("D");
        } else if (bridgeNumber == 1) {
            bridge.add("U");
        }
    }
}
