package bridge.domain;

import bridge.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Bridge bridge;
    private int tryCount;

    public GameController(InputView inputview, OutputView outputview, BridgeMaker bridgeMaker) {
        this.inputView = inputview;
        this.outputView = outputview;
        this.bridge = initializeGame(bridgeMaker);
        this.tryCount = 0;
    }

    private Bridge initializeGame(BridgeMaker bridgeMaker) {
        outputView.printGameStart();
        try {
            return createBridge(bridgeMaker);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return createBridge(bridgeMaker);
        }
    }

    public void playGame() {
        RetryQuit retryQuit = RetryQuit.RETRY;
        BridgeGame bridgeGame = new BridgeGame(bridge);
        while (!retryQuit.equals(RetryQuit.QUIT)) {
            if (retryGame(bridgeGame)) {
                break;
            }
            retryQuit = getRetryQuit();
        }
        endGame(bridgeGame, retryQuit);
    }

    private boolean retryGame(BridgeGame bridgeGame) {
        this.tryCount++;
        bridgeGame.retry();
        if (play(bridgeGame)) {
            return true;
        }
        return false;
    }

    private boolean play(BridgeGame bridgeGame) {
        while (!bridgeGame.isSameLength()) {
            bridgeGame.move(getDirection());
            outputView.printMap(bridgeGame.getUsersRoute(), bridge);
            if (bridgeGame.isFail()) {
                return false;
            }
        }
        return true;
    }

    private void endGame(BridgeGame bridgeGame, RetryQuit retryQuit) {
        outputView.printFinalResult(bridgeGame.getUsersRoute(), bridge);
        if (retryQuit.equals(RetryQuit.RETRY)) {
            outputView.printResult(tryCount, true);
            return;
        }
        outputView.printResult(tryCount, false);
    }

    private int getBridgeLength() {
        try {
            outputView.printGetBridgeLength();
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getBridgeLength();
        }
    }

    private Bridge createBridge(BridgeMaker bridgeMaker) {
        int bridgeLength = getBridgeLength();
        try {
            return new Bridge(bridgeMaker.makeBridge(bridgeLength));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return createBridge(bridgeMaker);
        }
    }

    private String getDirection() {
        try {
            outputView.printGetMoveDirection();
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getDirection();
        }
    }

    private RetryQuit getRetryQuit() {
        try {
            outputView.printGetRetry();
            return RetryQuit.convert(inputView.readGameCommand());
        } catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return getRetryQuit();
        }
    }

}
