package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        bridgeInit();
        while (!bridgeGame.isEnd()) {
            move();
            if (gameFailCheck()) {
                return;
            }
        }
        gameEnd();
    }
    private void bridgeInit() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }
    private void move() {
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame.getResult());
    }
    private void gameEnd() {
        outputView.printResult(bridgeGame.getResult(), bridgeGame.isGameFail(), BridgeGame.tryCount);
    }
    private boolean gameFailCheck() {
        if (bridgeGame.isGameFail()) {
            if (inputView.readGameCommand().equals("Q")) {
                gameEnd();
                return true;
            }
            bridgeGame.retry();
        }
        return false;
    }
}
