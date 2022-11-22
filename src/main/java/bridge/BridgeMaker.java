package bridge;

import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<Integer> temporaryBridge = new ArrayList<>();
        for (int length = 0; length < size; length++) {
            temporaryBridge.add(bridgeNumberGenerator.generate());
        }
        List<String> bridge = compareBridge(temporaryBridge);
        return bridge;
    }

    private List<String> compareBridge(List<Integer> temporaryBridge) {
        List<String> bridge = new ArrayList<>();
        for (int idx = 0; idx < temporaryBridge.size(); idx++) {
            if (temporaryBridge.get(idx) == 0) {
                bridge.add("D");
                continue;
            }
            bridge.add("U");
        }
        return bridge;
    }
}
