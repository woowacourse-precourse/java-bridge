package bridge.controller;

import bridge.model.Bridge;
import bridge.util.BridgeMaker;
import bridge.view.InputView;
import java.util.List;

public class BridgeGameController {
    Bridge gameBridge;
    List<String> playerChoise;

    public BridgeGameController() {
        this.gameBridge = makeGameBridge();
    }

    private Bridge makeGameBridge() {
        int bridgeSize = InputView.readBridgeSize();
        return BridgeMaker.makeBridge(bridgeSize);
    }
}
