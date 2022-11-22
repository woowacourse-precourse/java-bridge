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
            generateRandomUpDown(bridge);
        }
        return bridge;
    }

    public void generateRandomUpDown(List<String> bridge) {
        int upDownNumber = bridgeNumberGenerator.generate();

        if (upDownNumber == 0) {
            bridge.add("D");
        }
        if (upDownNumber == 1) {
            bridge.add("U");
        }
    }
}
