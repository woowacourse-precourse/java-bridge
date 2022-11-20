package bridge;

import bridge.controller.BridgeGameController;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGameController gameController = new BridgeGameController();

        OutputView.printStartMessage();
        gameController.start();
        gameController.end();
    }
}
