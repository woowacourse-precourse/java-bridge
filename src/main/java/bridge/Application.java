package bridge;

import bridge.controller.GameController;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final InputView inputView = new InputView();
        final OutputView outputView =new OutputView();
        final GameController gameController = new GameController(inputView,outputView);

        gameController.start();
    }
}
