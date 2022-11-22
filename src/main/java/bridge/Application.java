package bridge;

import bridge.controller.BridgeController;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
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
