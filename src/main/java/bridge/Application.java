package bridge;

import bridge.app.BridgeGame;
import bridge.controller.BridgeController;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    public static void main(String[] args) {
        BridgeGame bridgeGame = getInitializedGame();
        bridgeGame.run();
    }

    private static BridgeGame getInitializedGame() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeController bridgeController = new BridgeController(inputView, outputView);

        return new BridgeGame(bridgeController, new BridgeRandomNumberGenerator());
    }
}
