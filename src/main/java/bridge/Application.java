package bridge;

import bridge.controller.BridgeGameController;

import static bridge.view.OutputView.printStartMessage;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGameController gameController = new BridgeGameController();

        printStartMessage();
        gameController.start();
        gameController.end();
    }
}