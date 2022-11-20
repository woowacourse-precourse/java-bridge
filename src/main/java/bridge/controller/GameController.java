package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.OutputView;

import java.util.List;

import static bridge.enums.Constant_BridgeGame.UP_SIDE_PROGRESS;
import static bridge.enums.Constant_BridgeGame.DOWN_SIDE_PROGRESS;

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
            outputView.printMap(this.bridgeGame.getProgress().get(UP_SIDE_PROGRESS.get()));
            outputView.printMap(this.bridgeGame.getProgress().get(DOWN_SIDE_PROGRESS.get()));
        }
    }
}
