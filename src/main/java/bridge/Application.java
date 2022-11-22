package bridge;

import bridge.controller.GameController;
import bridge.view.TypeChange;
import bridge.view.Verification;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController(new InputView(new Verification(), new TypeChange()), new OutputView());
        gameController.play();
    }
}
