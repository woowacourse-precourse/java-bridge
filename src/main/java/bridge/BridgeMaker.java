package bridge;

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
                .map(i -> bridgeNumberGenerator.generate())
                .mapToObj(this::toBridgeCell)
                .collect(Collectors.toList());
    }

    private String toBridgeCell(int value) {
        if (value == 0) {
            return "D";
        }
        return "U";
    }
}
