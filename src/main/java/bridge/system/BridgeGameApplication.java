package bridge.system;

import bridge.controller.BridgeController;
import bridge.domain.BridgeResult;
import bridge.domain.GameState;
import bridge.domain.Phase;

public class BridgeGameApplication {

    public void execute() {
        BridgeController bridgeController = new BridgeController();
        bridgeController.playBridgeGame(new Phase(), new BridgeResult(), new GameState(1, true));
    }
}
