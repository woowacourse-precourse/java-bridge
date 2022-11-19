package bridge.controller;

import bridge.controller.InputController;
import bridge.model.BridgeGame;

public class GameController {

    InputController inputController = new InputController();

    public void initGame() {
        int bridgeSize = inputController.inputBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);
    }
}
