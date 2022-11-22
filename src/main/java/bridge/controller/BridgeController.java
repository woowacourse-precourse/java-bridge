package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.enums.GameCommand;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
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
        outputView.printResult(bridgeGame.getResult(), bridgeGame.isGameFail(), bridgeGame.getTryCount());
    }
    private boolean gameFailCheck() {
        if (bridgeGame.isGameFail()) {
            if (GameCommand.QUIT.isSame(inputView.readGameCommand())) {
                gameEnd();
                return true;
            }
            bridgeGame.retry();
        }
        return false;
    }
}
