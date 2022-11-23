package bridge;

import bridge.controller.BridgeGameController;
import bridge.exception.ExceptionHandler;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController =
                new BridgeGameController(new InputView(), new OutputView(), new ExceptionHandler());
        bridgeGameController.start();
    }
}
