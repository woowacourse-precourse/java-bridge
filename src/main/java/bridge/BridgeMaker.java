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
        for (int currentBridgeSize = 0; currentBridgeSize < size; currentBridgeSize++) {
            int upDown = bridgeNumberGenerator.generate();
            if (upDown == 1) {
                bridge.add("U");
                continue;
            }
            bridge.add("D");
        }
        return bridge;
    }
}
