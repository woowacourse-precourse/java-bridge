package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final int RANDOM_UPPER_INCLUSIVE = 1;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridge.add(changeNumToAlphabet(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    public String changeNumToAlphabet(int number) {
        if (number == RANDOM_UPPER_INCLUSIVE) {
            return UP;
        }
        return DOWN;
    }
}
