package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private static final BridgeStep[] STEPS_FOR_GENERATED_NUMBERS = new BridgeStep[] {BridgeStep.DOWN, BridgeStep.UP};

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        int count = 0;

        while (count < size) {
            BridgeStep step = STEPS_FOR_GENERATED_NUMBERS[this.bridgeNumberGenerator.generate()];
            bridge.add(step.getValue());
            count++;
        }

        return bridge;
    }
}
