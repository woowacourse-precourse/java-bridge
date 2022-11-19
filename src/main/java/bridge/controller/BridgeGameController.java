package bridge.controller;

import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    BridgeGame bridgeGame = new BridgeGame();

    public void run() {
        start();
        play();
    }

    private void play() {
        bridgeGame.move(inputView.readMoving());
    }

    private void start() {
        outputView.printStart();
        bridgeGame.createBridge(inputView.readBridgeSize());
        bridgeGame.newGame();
    }
}
