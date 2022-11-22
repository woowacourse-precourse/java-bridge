package bridge;

import bridge.controller.BridgeGameController;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeGameController bridgeGameController = new BridgeGameController(bridgeMaker, inputView, outputView);
        bridgeGameController.run();
    }

}
