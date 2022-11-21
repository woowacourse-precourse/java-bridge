package bridge;

import bridge.constant.Moving;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int position = 0; position < size; position++) {
            bridge.add(Moving.getNextAnswer(bridgeNumberGenerator.generate()).toString());
        }
        return bridge;
    }
}
