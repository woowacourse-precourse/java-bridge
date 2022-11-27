package bridge;

import java.util.LinkedList;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            bridge.add(makerUpDownBridge());
        }
        return bridge;
    }

    public String makerUpDownBridge() {
        if (bridgeNumberGenerator.generate() == 1) {
            return "U";
        }
        return "D";
    }

}
