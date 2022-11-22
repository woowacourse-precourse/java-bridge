package bridge.controller;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeSize;
import bridge.domain.game.BridgeGame;
import bridge.service.BridgeService;
import bridge.view.InputView;

public class BridgeController {

    private final InputView inputView = new InputView();

    private final BridgeService bridgeService;

    public BridgeController(BridgeService bridgeService) {
        this.bridgeService = bridgeService;
    }

    public Bridge createBridge() {
        int size = inputView.readBridgeSize();
        BridgeSize bridgeSize = new BridgeSize(size);
        return bridgeService.createBridge(bridgeSize.get());
    }

    public BridgeGame createBridgeGame(Bridge bridge) {
        return new BridgeGame(bridge);
    }
}
