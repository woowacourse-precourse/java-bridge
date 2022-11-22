package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.Instances.Setting.*;

public class BridgeMaker {
    private static final int NUMBER_DOWN = 0;
    private static final int NUMBER_UP = 1;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int random = bridgeNumberGenerator.generate();
            if (random == NUMBER_UP) {
                bridge.add(MOVING_UP);
            } else if (random == NUMBER_DOWN) {
                bridge.add(MOVING_DOWN);
            }
        }
        return bridge;
    }
}

