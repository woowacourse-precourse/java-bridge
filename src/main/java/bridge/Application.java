package bridge;

import bridge.controller.BridgeGameController;
import bridge.service.BridgeGame;

import static bridge.view.OutputView.printStartMessage;

public class Application {

    public static void main(String[] args) {
        BridgeGameController gameController = new BridgeGameController();
        BridgeGame bridgeGame = new BridgeGame();

        printStartMessage();
        gameController.start();
        gameController.end();
    }
}
