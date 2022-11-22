package bridge;

import controller.BridgeGameController;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        final BridgeGameController bridgeGameController =
                new BridgeGameController(new InputView(), new OutputView());
        bridgeGameController.startGame();
    }
}
