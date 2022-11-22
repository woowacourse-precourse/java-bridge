package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int shapeIndex = 0; shapeIndex < size; shapeIndex++) {
            Direction direction = Direction.of(bridgeNumberGenerator.generate());
            bridge.add(direction.getFloor());
        }
        return bridge;
    }
}
