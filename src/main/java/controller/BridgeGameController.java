package controller;

import view.InputView;
import view.OutputView;

public class BridgeGameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void startGame() {
        outputView.printMessage(Message.START_GAME);
        generateBridge();
    }

    private void generateBridge() {
        outputView.printMessage(Message.REQUEST_BRIDGE_SIZE);
        String bridgeSize = inputView.readBridgeSize();
    }
}
