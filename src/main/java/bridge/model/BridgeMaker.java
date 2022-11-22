package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {

        List<String> bridges = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridges.add(addBridge());
        }
        return bridges;
    }

    private String addBridge() {
        if (bridgeNumberGenerator.generate() == 1) {
            return "U";
        }
        return "D";
    }
}
