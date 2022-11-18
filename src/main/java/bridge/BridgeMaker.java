package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> generatedBridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomNumber = this.bridgeNumberGenerator.generate();
            if (randomNumber == 0) generatedBridge.add("D");
            if (randomNumber == 1) generatedBridge.add("U");
        }

        return generatedBridge;
    }
}
