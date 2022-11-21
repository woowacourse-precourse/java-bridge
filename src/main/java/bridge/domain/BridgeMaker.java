package bridge.domain;

import bridge.BridgeNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public final static List<String> UP_DOWN_SELECTOR = List.of("U", "D");

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        return  IntStream.range(0, size)
                .map(n -> bridgeNumberGenerator.generate())
                .mapToObj(UP_DOWN_SELECTOR::get)
                .collect(toList());
    }
}
