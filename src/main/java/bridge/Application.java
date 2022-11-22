package bridge;

import bridge.controller.BridgeGameController;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        BridgeGameController bridgeGameController = BridgeGameController.of(new InputView(),
                new OutputView());
        bridgeGameController.run();
    }
}
