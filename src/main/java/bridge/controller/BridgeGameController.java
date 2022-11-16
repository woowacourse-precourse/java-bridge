package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private int bridgeSize;

    public static BridgeGameController create(){
        return new BridgeGameController();
    }

    public void start(){
        startGame();
        run();
    }

    private void run(){
        
    }

    private void startGame(){
        outputView.printStart();
        bridgeSize = inputView.readBridgeSize();
    }
}
