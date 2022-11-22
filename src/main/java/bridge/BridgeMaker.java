package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;
    public static List<String> bridge = new ArrayList<>();

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        bridge.clear();
        for (int i = 0; i < size; i++) {
            int a = this.bridgeNumberGenerator.generate();
            if (a == 0) {
                BridgeGame.bridge_answer.add("D");
                bridge.add("D");
            }
            if (a == 1) {
                BridgeGame.bridge_answer.add("U");
                bridge.add("U");
            }
        }
        return bridge;
    }
}
