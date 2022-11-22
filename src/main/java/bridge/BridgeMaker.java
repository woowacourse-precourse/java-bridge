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
        for (int count = 0; count < size; count++){
            if (bridgeNumberGenerator.generate() == 0) {
                bridge.add("D");
                continue;
            }
            bridge.add("U");
        }
        return bridge;
    }
}
