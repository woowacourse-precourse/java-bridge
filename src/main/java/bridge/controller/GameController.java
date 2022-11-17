package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    void gameInit() {
        outputView.gameStart();
    }
}
