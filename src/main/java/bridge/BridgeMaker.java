package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static bridge.constant.BridgeGameConstant.*;

public class BridgeMaker {

    private static final Map<Integer, String> bridgeBlocks = new HashMap<>();
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        bridgeBlocks.put(DOWN_BRIDGE_BLOCK_NUMBER, DOWN_BRIDGE_BLOCK);
        bridgeBlocks.put(UP_BRIDGE_BLOCK_NUMBER, UP_BRIDGE_BLOCK);
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int bridgeSize = 0; bridgeSize < size; bridgeSize++) {
            int bridgeBlockNumber = bridgeNumberGenerator.generate();
            bridge.add(bridgeBlocks.get(bridgeBlockNumber));
        }
        return bridge;
    }
}
