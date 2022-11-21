package bridge;

import bridge.constant.Moving;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private static final int RANDOM_UPPER_INCLUSIVE = 1;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
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
