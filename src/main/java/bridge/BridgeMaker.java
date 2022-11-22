package bridge;

import bridge.enums.Inputs;
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
            bridge.add(generateCorrectMove());
        }
        return bridge;
    }

    private String generateCorrectMove() {
        if (bridgeNumberGenerator.generate() == 0) {
            return Inputs.MOVE_DOWN.getMessage();
        }
        return Inputs.MOVE_UP.getMessage();
    }
}
