package bridge;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        GameController gameController =
                new GameController(new InputView(), new OutputView(), new BridgeGame());
        gameController.start();
    }
}
