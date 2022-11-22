package bridge;

import bridge.controller.GameController;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(new BridgeRandomNumberGenerator()));

        GameController gameController = new GameController(inputView, outputView, bridgeGame);
        gameController.start();
    }
}
