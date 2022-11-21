package bridge;

import java.util.LinkedList;
import java.util.List;

public class BridgeMaker {

    private static int UP_BRIDGE_NUMBER = 1;
    private static String UP_BRIDGE = "U";
    private static String DOWN_BRIDGE = "D";
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            bridge.add(convertBridgeNumberToBridgeString(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    private String convertBridgeNumberToBridgeString(int bridgeNumber) {
        if (bridgeNumber == UP_BRIDGE_NUMBER) {
            return UP_BRIDGE;
        }
        return DOWN_BRIDGE;
    }
}
