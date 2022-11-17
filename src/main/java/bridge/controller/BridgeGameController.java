package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    OutputView outputView;
    InputView inputView;

    public BridgeGameController() {
        outputView = new OutputView();
        inputView = new InputView();
    }

    public void startGame() {
        outputView.printStartGame();
        int number = getBridgeSize();
    }

    public int getBridgeSize() {
        while (true) {
            try{
              return inputView.readBridgeSize();
            }catch(IllegalArgumentException iae) {
                outputView.printError(iae.getMessage());
            }
        }
    }
}