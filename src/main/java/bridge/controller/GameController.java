package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    InputView inputView = new InputView();
    OutputView  outputView = new OutputView();

    private void informStart() {
        outputView.printStartGame();
    }
}
