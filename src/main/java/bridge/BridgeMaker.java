package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> Bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int test = bridgeNumberGenerator.generate();
            if (test == 0) Bridge.add("D");
            if (test == 1) Bridge.add("U");
        }
        return Bridge;
    }
}
