package bridge.util;

import bridge.BridgeNumberGenerator;
import bridge.domain.bridgeenum.MovePosition;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int index = 0; index < size; index++) {
            bridge.add(generateMovePosition());
        }
        return bridge;
    }

    private String generateMovePosition() {
        return MovePosition.getMatchingMovePosition(bridgeNumberGenerator.generate());
    }
}
