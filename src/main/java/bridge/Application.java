package bridge;

import bridge.controller.BridgeGameController;

import static bridge.view.OutputView.printStartMessage;

public class Application {

    public static void main(String[] args) {
        BridgeGameController gameController = new BridgeGameController();

        printStartMessage();
        gameController.start();
        gameController.end();
    }
}
