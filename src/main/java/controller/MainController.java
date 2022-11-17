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
        int bridgeSize = readBridgeSize();
        return new Bridge(bridgeSize);
    }



    private void printReceiveBridgeSize(){
        outputView.printReceiveBridgeSize();
    }

    private int readBridgeSize(){
        return inputView.readBridgeSize();
    }
}
