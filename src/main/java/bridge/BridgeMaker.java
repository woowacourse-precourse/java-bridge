package bridge;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BridgeMaker {
    private static final Map<Integer, String> UP_OR_DOWN = Map.of(
            1, Constants.CODE_UP,
            0, Constants.CODE_DOWN
    );

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> UP_OR_DOWN.get(bridgeNumberGenerator.generate()))
                .collect(Collectors.toList());
    }
}
