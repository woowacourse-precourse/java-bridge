package bridge;

import bridge.controller.BridgeGameController;
import bridge.view.OutputView;

public class Application {

    private static final BridgeGameController bridgeGameController = new BridgeGameController();

    public static void main(String[] args) {
        OutputView.printStart();

        bridgeGameController.createBridge();
        bridgeGameController.run();
    }
}
