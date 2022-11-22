package bridge;

import bridge.domain.move.MoveType;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        return IntStream.range(0, size)
                .mapToObj(x -> MoveType.of(bridgeNumberGenerator.generate()).symbol())
                .collect(Collectors.toList());
    }
}
