package bridge;

import bridge.controller.BridgeGameController;
import bridge.ui.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGameController controller = new BridgeGameController();
        OutputView.printStartMessage();
        controller.startNewGame();
        controller.runGame();
    }
}
