package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGameController bridgeGameController = new BridgeGameController(
                new InputView(),
                new OutputView(),
                new BridgeMaker(new BridgeRandomNumberGenerator())
        );
        bridgeGameController.run();
    }
}
