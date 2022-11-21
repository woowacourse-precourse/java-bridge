package bridge;

import bridge.view.ViewController;

public class BridgeApp {
    private final ViewController viewController;
    private final BridgeGame bridgeGame;

    public BridgeApp(ViewController viewController, BridgeGame bridgeGame) {
        this.viewController = viewController;
        this.bridgeGame = bridgeGame;
    }

    public void run() {
        bridgeGame.createBridge(viewController.readBridgeSize());
        viewController.printResult(playAndGetResult());

    }

}
