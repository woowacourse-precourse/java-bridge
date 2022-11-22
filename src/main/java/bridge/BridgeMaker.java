package bridge;

import bridge.Constant.BridgeValue;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private static final int UP = 1;
    private static final int ZERO = 0;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(final int size) {
        List<String> bridge = new ArrayList<>();
        for (int count = ZERO; count < size; count++) {
            int number = bridgeNumberGenerator.generate();
            bridge.add(changeUpAndDown(number));
        }
        return bridge;
    }

    private String changeUpAndDown(final int number) {
        if (number == UP) {
            return BridgeValue.UP.value();
        }
        return BridgeValue.DOWN.value();
    }
}
