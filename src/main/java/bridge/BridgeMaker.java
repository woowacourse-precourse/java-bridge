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
        List<Integer> bridges = new ArrayList<>();

        fillBridgeNumber(size, bridges);

        return bridges.stream()
                .map(number -> Direction.directionNumberToDirection(number))
                .collect(Collectors.toList());
    }

    private void fillBridgeNumber(int size, List<Integer> bridges) {
        for (int index = 0; index < size; index++) {
            int number = bridgeNumberGenerator.generate();
            bridges.add(number);
        }
    }
}
