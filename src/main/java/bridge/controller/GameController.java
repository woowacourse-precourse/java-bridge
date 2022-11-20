package bridge.controller;

import bridge.controller.InputController;
import bridge.model.BridgeGame;
import bridge.view.OutputView;

public class GameController {

    InputController inputController = new InputController();
    OutputView outputView = new OutputView();


    public void initGame() {
        outputView.printStart();
        int bridgeSize = inputController.inputBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);
    }
}
