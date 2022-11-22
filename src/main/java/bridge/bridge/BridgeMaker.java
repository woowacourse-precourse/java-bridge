package bridge.bridge;

import static bridge.bridge.BridgePosition.BRIDGE_DOWN;
import static bridge.bridge.BridgePosition.BRIDGE_UP;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        return Stream.generate(bridgeNumberGenerator::generate).map(this::getPosition).limit(size)
                .collect(Collectors.toList());
    }

    private String getPosition(Integer number) {
        if (number == 0) {
            return BRIDGE_DOWN.getPosition();
        }
        return BRIDGE_UP.getPosition();
    }
}
