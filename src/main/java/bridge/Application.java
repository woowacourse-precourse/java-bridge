package bridge;

import bridge.controller.GameController;
import bridge.view.TypeChange;
import bridge.view.Valification;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController(new InputView(new Valification(), new TypeChange()), new OutputView());
        gameController.play();
    }
}
