package bridge;

import bridge.model.Space;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Space space = createRandomSpace();
            bridge.add(space.getValue());
        }
        return Collections.unmodifiableList(bridge);
    }

    private Space createRandomSpace() {
        int bridgeNumber = bridgeNumberGenerator.generate();
        return Space.from(bridgeNumber);
    }
}
