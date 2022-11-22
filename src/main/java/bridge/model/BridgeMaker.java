package bridge.model;

import bridge.BridgeNumberGenerator;
import bridge.config.BridgeComponent;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private static final int BRIDGE_MINIMUM = 3;
    private static final int BRIDGE_MAXIMUM = 20;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }
    public List<String> makeBridge(int size) {
        validateSize(size);
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridge.add(makeOneSquare());
        }
        return bridge;
    }

    private void validateSize(int size) {
        if (size < BRIDGE_MINIMUM || size > BRIDGE_MAXIMUM) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private String makeOneSquare() {
        int randomNumber = bridgeNumberGenerator.generate();
        return BridgeComponent.findByNumber(randomNumber);
    }
}
