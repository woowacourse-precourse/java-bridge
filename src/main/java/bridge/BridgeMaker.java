package bridge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static bridge.utils.Constants.SPACE_NAME;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        return IntStream.range(0, size)
                .map(i -> bridgeNumberGenerator.generate())
                .mapToObj(this::mapToBridge)
                .collect(Collectors.toList());
    }

    private String mapToBridge(int positionNumber) {
        return SPACE_NAME.get(positionNumber);
    }
}
