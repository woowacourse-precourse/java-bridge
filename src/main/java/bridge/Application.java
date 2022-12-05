package bridge;

import controller.BridgeGameController;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController(new OutputView(), new InputView());
        bridgeGameController.startGame(new BridgeGame());
    }
}