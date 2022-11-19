package bridge;

import bridge.domain.BridgeGame;
import bridge.controller.BridgeGameController;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController(
                new InputView(),
                new OutputView(),
                new BridgeGame()
        );
        bridgeGameController.process();
    }
}
