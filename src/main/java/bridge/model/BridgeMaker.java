package bridge.model;

import bridge.model.interfaces.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final int DOWN = 0;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(final int size) {
        List<String> bridge = new ArrayList<>();
        for (int repeat = 0; repeat < size; repeat++) {
            bridge.add(generateAnswer());
        }
        return bridge;
    }

    private String generateAnswer() {
        int generatedNumber = bridgeNumberGenerator.generate();
        if (generatedNumber == DOWN) {
            return "D";
        }
        return "U";
    }
}
