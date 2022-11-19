package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;

public class BridgeService {
    private final InputService inputService = new InputService();
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    public Bridge bridgeMaker() {
        int bridgeSize = getBridgeSize();
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        return bridge;
    }

    public int getBridgeSize() {
        return inputService.requestBridgeSize();
    }
}
