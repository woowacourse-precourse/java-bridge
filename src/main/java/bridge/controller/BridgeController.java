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
        outputView.announceStartGame();
        createBridgeGame();
        do {
            playTurn();
        } while (!bridgeGame.isEnd());
        announceFinalResult();
    }

    private void createBridgeGame() {
        int inputSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(inputSize);
        this.bridgeGame = new BridgeGame(bridge);
    }

    private void playTurn() {
        String moving = inputView.readMoving();
        String bridgeSketch = bridgeGame.move(moving);
        outputView.printMap(bridgeSketch);
        if (bridgeGame.isFail()) {
            String gameCommand = inputView.readGameCommand();
            bridgeGame.retry(gameCommand);
        }
    }

    private void announceFinalResult() {
        boolean isSuccess = bridgeGame.isSuccess();
        outputView.announceEndGame();
        String bridgeSketch = bridgeGame.getSketch();
        outputView.printMap(bridgeSketch);
        int tryCount = bridgeGame.getTryCount();
        outputView.printResult(isSuccess, tryCount);
    }
}
