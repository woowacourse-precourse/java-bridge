package bridge;

import bridge.controller.BridgeController;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController(
            new InputView(),
            new OutputView(),
            new BridgeMaker(new BridgeRandomNumberGenerator())
        );
        bridgeController.bridgeGameStart();
    }
}
