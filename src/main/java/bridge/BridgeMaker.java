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
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int number = bridgeNumberGenerator.generate();
            bridge.add(toKey(number));
        }
        return bridge;
    }

    private String toKey(int number) {
        if (number == 1)
            return Moving.UP.getKey();
        if (number == 0)
            return Moving.DOWN.getKey();
        return null;
    }
}
