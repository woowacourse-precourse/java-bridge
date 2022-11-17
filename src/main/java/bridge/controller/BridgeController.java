package bridge.controller;

import bridge.InputView;
import bridge.OutputView;

public class BridgeController {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();

    public void startGame(){
        outputView.printStartingPhrase();

    }

    public void inputBridgeSize(){
        inputView.readBridgeSize();

    }

}
