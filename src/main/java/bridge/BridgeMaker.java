package bridge;

import bridge.domain.Direction;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        return IntStream.generate(bridgeNumberGenerator::generate).limit(size)
                .mapToObj(Direction::from)
                .map(String::valueOf)
                .collect(Collectors.toList());
    }
}
