package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BridgeMaker {

    private static final Map<Integer, String> bridgeBlocks = new HashMap<>();
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        bridgeBlocks.put(0, "D");
        bridgeBlocks.put(1, "U");
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int bridgeSize = 0; bridgeSize < size; bridgeSize++) {
            int bridgeNumber = bridgeNumberGenerator.generate();
            bridge.add(bridgeBlocks.get(bridgeNumber));
        }
        return bridge;
    }
}
