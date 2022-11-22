package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.BridgeRandomNumberGenerator.RANDOM_LOWER_INCLUSIVE;

public class BridgeMaker {

    private static final String DOWN = "D";
    private static final String UP = "U";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (isLower(bridgeNumberGenerator.generate())) {
                bridge.add(DOWN);
                continue;
            }
            bridge.add(UP);
        }
        return bridge;
    }

    private boolean isLower(int inclusive) {
        return inclusive == RANDOM_LOWER_INCLUSIVE;
    }
}
