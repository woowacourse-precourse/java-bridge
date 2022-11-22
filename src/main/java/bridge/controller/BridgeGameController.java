package bridge.controller;

import bridge.BridgeGame;
import bridge.views.InputView;
import bridge.views.OutputView;

public class BridgeGameController {

    InputView inputView;
    OutputView outputView;

    BridgeGame bridgeGame;

    public void start() {
        initComponents();
        outputView.printWelcome();
    }

    private void initComponents(){
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
    }
}
