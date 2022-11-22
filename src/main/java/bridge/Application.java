package bridge;

import bridge.controller.GameController;
import bridge.view.OutputView;

public class Application {
    private static final OutputView outputView = new OutputView();
    public static void main(String[] args) {
        outputView.printStart();
        GameController gameController = new GameController();
        gameController.play();
    }
}
