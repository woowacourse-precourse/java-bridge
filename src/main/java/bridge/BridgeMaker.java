package bridge;

import static bridge.InputView.DOWN;
import static bridge.InputView.UP;

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
            bridge.add(getBridgeNumber());
        }
        return bridge;
    }

    private String getBridgeNumber() {
        if (bridgeNumberGenerator.generate() == 1) {
            return UP;
        }
        return DOWN;
    }
}