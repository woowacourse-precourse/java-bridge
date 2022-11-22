package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private BridgeGame bridgeGame;

    public void run() {
        outputView.printIntro();
        setGame(requestBridgeSize());
        playGame();
        outputView.printResult(bridgeGame);
    }

    public void setGame(int size) {
        try {
            bridgeGame = new BridgeGame(size);
        } catch (IllegalArgumentException e) {
            outputView.printError();
            setGame(requestBridgeSize());
        }
    }

    public int requestBridgeSize() {
        try {
            outputView.printRequestBridgeSize();
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            outputView.printError();
            return requestBridgeSize();
        }
    }

    private void playGame() {
        do {
            bridgeGame.retry();
            gameRound();
        } while (isGameOver());
    }

    public void gameRound() {
        while (cross()) {
            if (bridgeGame.isComplete()) {
                break;
            }
        }
    }

    public boolean isGameOver() {
        return !bridgeGame.isComplete() && requestRetry();
    }

    public boolean requestRetry() {
        try {
            outputView.printRequestGameCommand();
            return inputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            outputView.printError();
            return requestRetry();
        }
    }

    public boolean cross() {
        bridgeGame.move(requestMovingPoint());
        outputView.printMap(bridgeGame);
        return bridgeGame.isCrossedBridge();
    }

    public String requestMovingPoint() {
        try {
            outputView.printRequestMove();
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            outputView.printError();
            return requestMovingPoint();
        }
    }
}
