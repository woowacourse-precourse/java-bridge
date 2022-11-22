package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeGame bridgeGame = new BridgeGame();
        BridgeGameController bridgeGameController = new BridgeGameController(inputView, outputView, bridgeGame);

        bridgeGameController.playBridgeGame();
    }
}
