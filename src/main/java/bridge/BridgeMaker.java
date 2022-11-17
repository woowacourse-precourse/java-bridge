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
        for (int index = 0; index < size; index++) {
            String nextAnswer = "D";
            if (bridgeNumberGenerator.generate() == 1) {
                nextAnswer = "U";
            }
            bridge.add(nextAnswer);
        }
        return bridge;
    }
}
