package bridge;

import bridge.enums.BridgeMark;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BridgeMaker {

    public static final int START_INCLUSIVE_ZERO = 0;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        return IntStream.range(START_INCLUSIVE_ZERO, size)
                .mapToObj(i -> BridgeMark.mapToString(bridgeNumberGenerator.generate()))
                .collect(Collectors.toList());
    }
}
