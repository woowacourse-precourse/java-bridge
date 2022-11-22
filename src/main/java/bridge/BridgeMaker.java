package bridge;

import bridge.data.constant.OutputConstants;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (bridgeNumberGenerator.generate() == 0) {
                bridge.add(OutputConstants.DOWN);
                continue;
            }
            bridge.add(OutputConstants.UP);
        }
        return bridge;
    }
}
