package bridge;

import constants.BridgeConstants;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        while (size > 0) {
            int direction = bridgeNumberGenerator.generate();
            bridge.add(BridgeConstants.bridgeDirection.get(direction));
            size--;
        }

        return bridge;
    }
}
