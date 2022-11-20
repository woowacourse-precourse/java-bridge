package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.OutputView;

public class GameController {

    InputController inputController = new InputController();
    BridgeGame bridgeGame;
    OutputView outputView = new OutputView();

    public void initGame() {
        outputView.printStart();
        int bridgeSize = inputController.inputBridgeSize();
        this.bridgeGame = new BridgeGame(bridgeSize);

        startGame();
    }

    public void startGame() {
        while (bridgeGame.isContinue()) {
            String moving = inputController.inputMoving();
            this.bridgeGame.move(moving);
        }
    }
}
