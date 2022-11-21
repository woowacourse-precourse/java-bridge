package bridge;

import bridge.controller.BridgeGameController;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeGame bridgeGame = new BridgeGame();
        BridgeGameController controller = new BridgeGameController(inputView, outputView, bridgeGame);
        controller.run();
    }
}
