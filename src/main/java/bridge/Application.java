package bridge;

import bridge.controller.BridgeGame;
import bridge.router.BridgeGameRouter;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGameRouter bridgeGameRouter = new BridgeGameRouter(
                new InputView(),
                new OutputView(),
                new BridgeGame()
        );
        bridgeGameRouter.process();
    }
}
