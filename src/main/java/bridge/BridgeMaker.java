package bridge;

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
        while (bridge.size() < size) {
            bridge.add(generateMovePosition());
        }
        return bridge;
    }

    private String generateMovePosition() {
        return MovePosition.getMatchingMovePosition(bridgeNumberGenerator.generate());
    }
}
