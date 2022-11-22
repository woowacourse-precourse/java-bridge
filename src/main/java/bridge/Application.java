package bridge;

import bridge.controller.BridgeController;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    private static BridgeController bridgeController = new BridgeController();
    private static BridgeGame bridgeGame = new BridgeGame();
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        BridgeController bridgeController1 = new BridgeController();
        bridgeController1.gameStart();
    }
}
