package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.util.BridgeMaker;
import bridge.view.InputView;

public class BridgeGameController {
    Bridge gameBridge;
    BridgeGame bridgeGame;

    public BridgeGameController() {
        this.gameBridge = makeGameBridge();
        this.bridgeGame = new BridgeGame(gameBridge);
    }

    private Bridge makeGameBridge() {
        int bridgeSize = InputView.readBridgeSize();
        return BridgeMaker.makeBridge(bridgeSize);
    }
}
