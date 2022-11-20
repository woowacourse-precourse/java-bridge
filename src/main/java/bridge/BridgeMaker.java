package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridgeShape = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (checkUpperBridge(bridgeNumberGenerator.generate())) {
                bridgeShape.add("U");
                continue;
            }
            bridgeShape.add("D");
        }
        return bridgeShape;
    }

    private Boolean checkUpperBridge(int bridgeNumber) {
        return bridgeNumber == 1;
    }
}
