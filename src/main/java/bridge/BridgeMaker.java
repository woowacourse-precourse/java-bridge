package bridge;

import bridge.domain.Move;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = IntStream.range(0, size)
                .mapToObj(i -> Move.getPositionByNumber(bridgeNumberGenerator.generate()))
                .collect(Collectors.toList());
        return bridge;
    }
}
