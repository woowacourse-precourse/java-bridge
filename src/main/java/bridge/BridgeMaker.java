package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private static final Moving[] MOVINGS_FOR_GENERATED_NUMBERS = new Moving[] {Moving.DOWN, Moving.UP};

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        int count = 0;

        while (count < size) {
            Moving moving = MOVINGS_FOR_GENERATED_NUMBERS[this.bridgeNumberGenerator.generate()];
            bridge.add(moving.getValue());
            count++;
        }

        return bridge;
    }
}
