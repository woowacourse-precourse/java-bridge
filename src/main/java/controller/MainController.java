package controller;

import model.Bridge;
import view.InputView;
import view.OutputView;

public class MainController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    public void run(){
        startGame();
        Bridge bridge = getBridgeContainBridgeSize();

    }

    private void startGame(){
        outputView.printStartGame();
    }

    public Bridge getBridgeContainBridgeSize(){
        printReceiveBridgeSize();
        Bridge bridge = validateBridgeSize();
        return bridge;
    }

    private Bridge validateBridgeSize() {
        Bridge bridge = null;
        try {
            int bridgeSize = readBridgeSize();
            bridge = new Bridge(bridgeSize);
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            getBridgeContainBridgeSize();
        }
        return bridge;
    }


    private void printReceiveBridgeSize(){
        outputView.printReceiveBridgeSize();
    }

    private int readBridgeSize(){
        return inputView.readBridgeSize();
    }
}
