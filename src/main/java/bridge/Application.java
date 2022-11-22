package bridge;

import bridge.controller.Controller;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeGame bridgeGame = new BridgeGame();
        Controller controller = new Controller(bridgeGame, outputView, inputView);
        controller.startGame();
    }
}
