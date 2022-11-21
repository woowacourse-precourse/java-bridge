package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    public BridgeGameController(){
        outputView.gameStartPrint();
    }
}
