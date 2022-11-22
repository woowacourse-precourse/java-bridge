package bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeMaker {

    public final static String UP = "U";
    public final static String DOWN = "D";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int bridgeNumber = bridgeNumberGenerator.generate();
            bridge.add(convertNumberToString(bridgeNumber));
        }
        return Collections.unmodifiableList(bridge);
    }

    private String convertNumberToString(int number) {
        if (number == 1) {
            return UP;
        }
        return DOWN;
    }
}
