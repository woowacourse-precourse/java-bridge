package bridge;

import bridge.controller.GameController;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GameController gameController = new GameController(inputView, outputView);
        gameController.play();
    }
}
