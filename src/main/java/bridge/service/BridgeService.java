package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;

public class BridgeService {
    private final InputService inputService = new InputService();
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    public Bridge bridgeMaker() {
        gameStart();
        int bridgeSize = getBridgeSize();
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        return bridge;
    }

    public void gameStart() {
        inputService.printGameStart();
    }

    public int getBridgeSize() {
        return inputService.requestBridgeSize();
    }
}
