package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController(new InputView(),
                new OutputView(), new BridgeMaker(new BridgeRandomNumberGenerator()));
        bridgeGameController.play();
    }
}
