package bridge;

import bridge.BridgeNumberGenerator;
import bridge.type.Direction;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i=0; i<size; i++) {
            int direction = bridgeNumberGenerator.generate();
            if (direction == Direction.UP.getNumber()) {
                bridge.add(Direction.UP.getLetter());
                continue;
            }
            bridge.add(Direction.DOWN.getLetter());
        }
        return bridge;
    }
}
