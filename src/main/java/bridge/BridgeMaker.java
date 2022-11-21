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
            Bridge.add(String.valueOf(test));
        }
        return Bridge;
    }
}
