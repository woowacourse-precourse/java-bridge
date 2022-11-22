package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgePassed;
import bridge.service.BridgeGameService;

public class BridgeGameController {

    private final BridgeGameService bridgeGameService;

    public BridgeGameController(BridgeGameService bridgeGameService) {
        this.bridgeGameService = bridgeGameService;
    }

    public Bridge createBridge(int bridgeSize) {
        return bridgeGameService.createBridge(bridgeSize);
    }

    public BridgePassed showBridgePassed(Bridge bridge, int index, String moving) {
        return bridgeGameService.showBridgePassed(bridge, index, moving);
    }
}
