package bridge;

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
            int number = bridgeNumberGenerator.generate();
            String pattern = numToPattern(number);
            bridge.add(pattern);
        }
        return bridge;
    }

    private String numToPattern(int number) {
        if (number == 0)
            return "D";
        if (number == 1)
            return "U";
        return null;
    }
}
