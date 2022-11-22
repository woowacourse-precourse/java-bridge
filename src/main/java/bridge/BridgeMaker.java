package bridge;

import constants.BridgeForm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        IntStream.range(0, size)
                .forEach(i -> {
                    int value = bridgeNumberGenerator.generate();
                    bridge.add(BridgeForm.valueToDirection(value));
                });

        return bridge;
    }
}
