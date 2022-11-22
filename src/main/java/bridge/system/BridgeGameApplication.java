package bridge.system;

import bridge.controller.BridgeController;
import bridge.domain.result.BridgeResult;
import bridge.domain.result.GameResult;
import bridge.domain.bridge.Phase;

public class BridgeGameApplication {

    public void execute() {
        BridgeController bridgeController = new BridgeController();
        bridgeController.playBridgeGame(new Phase(), new BridgeResult(), new GameResult(1, true));
    }
}
