package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        ArrayList<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();
            enrollBridgePath(bridge, randomNumber);
        }
        return bridge;
    }

    private void enrollBridgePath(ArrayList<String> bridge, int randomNumber) {
        if (randomNumber == 0) {
            bridge.add("D");;
            return;
        }
        bridge.add("U");
    }
}
