package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<String>();

        for (int i = 0; i < size; i ++) {
            int number = bridgeNumberGenerator.generate();
            String direction = convertNumberToDirection(number);

            bridge.add(direction);
        }
        return bridge;
    }

    private String convertNumberToDirection(int number) {
        if (number == 0) {
            return "D";
        }
        if (number == 1) {
            return "U";
        }
        return null;
    }
}
