package controller;

import view.OutputView;

public class BridgeGameController {
    OutputView outputView = new OutputView();

    public void startGame() {
        outputView.printMessage(Message.START_GAME);
    }
}
