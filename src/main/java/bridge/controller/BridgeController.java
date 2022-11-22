package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.ui.InputView;
import bridge.ui.OutputView;
import java.util.List;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
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
        } while (bridgeGame.isOnWay());
        announceFinalResult();
    }

    private void createBridgeGame() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        this.bridgeGame = new BridgeGame(bridge);
    }

    private void playTurn() {
        try {
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getPicture());
            checkFail();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            playTurn();
        }
    }

    private void checkFail() {
        if (bridgeGame.isFail()) {
            retryGame();
        }
    }

    private void retryGame() {
        try {
            String gameCommand = inputView.readGameCommand();
            bridgeGame.retry(gameCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            retryGame();
        }
    }

    private void announceFinalResult() {
        outputView.announceEndGame();
        String bridgePicture = bridgeGame.getPicture();
        outputView.printMap(bridgePicture);
        boolean isSuccess = bridgeGame.isSuccess();
        int tryCount = bridgeGame.getTryCount();
        outputView.printResult(isSuccess, tryCount);
    }
}
