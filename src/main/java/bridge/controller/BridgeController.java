package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.ui.InputView;
import bridge.ui.OutputView;
import java.util.List;

public class BridgeController {
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        this.outputView.announceStartGame();
        createBridgeGame();
        do {
            playTurn();
        } while (!this.bridgeGame.isEnd());
        announceFinalResult();
    }

    private void createBridgeGame() {
        int inputSize = this.inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(inputSize);
        this.bridgeGame = new BridgeGame(bridge);
    }

    private void playTurn() {
        String moving = this.inputView.readMoving();
        String bridgeSketch = this.bridgeGame.move(moving);
        this.outputView.printMap(bridgeSketch);
        if (this.bridgeGame.isFail()) {
            String gameCommand = this.inputView.readGameCommand();
            this.bridgeGame.retry(gameCommand);
        }
    }

    private void announceFinalResult() {
        boolean isSuccess = this.bridgeGame.isSuccess();
        this.outputView.announceEndGame();
        String bridgeSketch = this.bridgeGame.getSketch();
        this.outputView.printMap(bridgeSketch);
        int tryCount = this.bridgeGame.getTryCount();
        this.outputView.printResult(isSuccess, tryCount);
    }
}
