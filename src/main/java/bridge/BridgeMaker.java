package bridge;

import bridge.domain.Direction;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<Integer> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridge.add(bridgeNumberGenerator.generate());
        }

        return bridge.stream().map(Direction::from).map(String::valueOf).collect(Collectors.toList());
    }
}
