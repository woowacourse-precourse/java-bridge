package bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        while (size > 0) {
            bridge.add(String.valueOf(bridgeNumberGenerator.generate()));
            size--;
        }
        Collections.replaceAll(bridge, "0", "D");
        Collections.replaceAll(bridge, "1", "U");
        return bridge;
    }
}
