package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private static final int ZERO = 0;
    private static final String UP = "U";
    private static final String DOWN = "D";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        while (bridge.size() < size) {
            bridge.add(generateBridgeShape());
        }
        return bridge;
    }

    private String generateBridgeShape() {
        if (bridgeNumberGenerator.generate() == ZERO) {
            return DOWN;
        }
        return UP;
    }
}
