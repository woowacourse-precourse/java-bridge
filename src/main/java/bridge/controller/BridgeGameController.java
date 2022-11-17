package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    OutputView outputView;

    public BridgeGameController() {
        outputView = new OutputView();
    }

    public void startGame() {
        outputView.printStartGame();
    }
}