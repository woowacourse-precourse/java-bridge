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
        final int RANDOM_UPPER_INCLUSIVE = 1;
        List<String> bridge = new ArrayList<>();
        for (int index = 0; index < size; index++) {
            String nextAnswer = Moving.D.toString();
            if (bridgeNumberGenerator.generate() == RANDOM_UPPER_INCLUSIVE) {
                nextAnswer = Moving.U.toString();
            }
            bridge.add(nextAnswer);
        }
        return bridge;
    }
}
