package bridge;

import bridge.controller.BridgeController;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeController gameController = initGameController();

        gameController.createBridge();
        do {
            gameController.move();
        } while (!gameController.isGameOver());

        gameController.gameOver();
    }

    private static BridgeController initGameController() {
        return new BridgeController(
                new BridgeGame(new BridgeRandomNumberGenerator()),
                new InputView(),
                new OutputView());
    }
}
