package bridge.controller;

import bridge.views.OutputView;

public class BridgeGameController {
    private final OutputView outputView = new OutputView();

    public void startGame() {
        outputView.printStartMessage();
    }
}
