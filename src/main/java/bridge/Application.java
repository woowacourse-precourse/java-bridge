package bridge;

import bridge.controller.BridgeGameController;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGameController gameController = new BridgeGameController(new InputView(), new OutputView());
        gameController.runGameMain();
    }
}
