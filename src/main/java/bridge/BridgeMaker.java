package bridge;

import constant.Values.BridgeCase;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        Checker checker = new Checker();
        size = checker.checkNegative(size);
        List<String> bridge = new ArrayList<>();
        generateValue(bridge, size);
        return bridge;
    }

    private List<String> generateValue(List<String> bridge, int size) {
        if (size <= 0) {
            return bridge;
        }
        if (bridgeNumberGenerator.generate() == 0) {
            return generateValue(bridge, size, BridgeCase.NEGATIVE);
        }
        return generateValue(bridge, size, BridgeCase.POSITIVE);
    }

    private List<String> generateValue(List<String> bridge, int size, BridgeCase bridgeCase) {
        bridge.add(bridgeCase.getValue());
        size -= 1;
        return generateValue(bridge, size);
    }

}
