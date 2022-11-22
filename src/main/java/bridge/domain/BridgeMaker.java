package bridge.domain;

import bridge.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private static final String UP_VALUE = "U";
    private static final String DOWN_VALUE = "D";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridge.add(upOrDown());
        }
        return bridge;

    }

    private String upOrDown() {
        int number = bridgeNumberGenerator.generate();
        if (number == 0) {
            return UP_VALUE;
        }
        return DOWN_VALUE;
    }
}
