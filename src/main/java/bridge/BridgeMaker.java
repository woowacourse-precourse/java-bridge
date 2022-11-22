package bridge;

import bridge.model.Direction;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridge.add(generateDirection());
        }
        return bridge;
    }

    private String generateDirection() {
        if (Direction.UP.isSame(bridgeNumberGenerator.generate())) {
            return Direction.UP.getDirection();
        }
        return Direction.DOWN.getDirection();
    }
}
