package bridge;

import static bridge.constant.BridgeRule.convertRandomNumberToMoving;

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
        IntStream.range(0, size).forEach(count -> {
            String moving = convertRandomNumberToMoving(bridgeNumberGenerator.generate());
            bridge.add(moving);
        });
        return bridge;
    }
}
