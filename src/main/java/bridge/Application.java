package bridge;

import bridge.controller.GameController;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController(new OutputView(), new InputView());
        gameController.start();
    }
}
