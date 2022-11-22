package bridge;

import bridge.util.BridgePosition;
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
                .mapToObj(index -> getBridgePosition(bridgeNumberGenerator.generate()))
                .collect(Collectors.toList());
    }

    public String getBridgePosition(int bridgeNumber) {
        if (BridgePosition.UP.isEqualToBridgeNumber(bridgeNumber)) {
            return BridgePosition.UP.getBridgePosition();
        }

        return BridgePosition.DOWN.getBridgePosition();
    }
}
