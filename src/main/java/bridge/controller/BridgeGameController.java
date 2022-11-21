package bridge.controller;

import bridge.constant.AfterMovingStatusConstant;
import bridge.constant.RetryExitConstant;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private int gameCount = 0;
    public void start() {
        BridgeGame bridgeGame = new BridgeGame(bridgeLengthInputView());
        while (true) {
            boolean doRetry = thisTurnBridgeGame(bridgeGame);
            if (!doRetry) {
                break;
            }
        }
    }

    private boolean thisTurnBridgeGame(BridgeGame bridgeGame) {
        AfterMovingStatusConstant afterMovingStatusConstant = thisTurnGame(bridgeGame);
        if (afterMovingStatusConstant.isGameSuccess()) {
            thisGameResultView(bridgeGame, afterMovingStatusConstant);
            return false;
        }
        RetryExitConstant retryExitConstant = gameRetryOrExitView();
        return isFinishThisGame(bridgeGame, retryExitConstant);
    }

    private AfterMovingStatusConstant thisTurnGame(BridgeGame bridgeGame) {
        gameCount += 1;
        while (true) {
            AfterMovingStatusConstant movingStatus = bridgeGame.move(thisTurnMoveBridgeInputView());
            thisTurnMovingResult(bridgeGame.thisTurnBridge());
            if (movingStatus.isFinishThisTurn()) {
                return movingStatus;
            }
        }
    }

    private void thisTurnMovingResult(String thisTurnBridge) {
        outputView.printMap(thisTurnBridge);
    }

    private static boolean isFinishThisGame(BridgeGame bridgeGame, RetryExitConstant retryExitConstant) {
        if (retryExitConstant.retry()) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }

    private void thisGameResultView(BridgeGame bridgeGame, AfterMovingStatusConstant afterMovingStatusConstant) {
        outputView.printResult(bridgeGame.thisTurnBridge(), afterMovingStatusConstant, gameCount);
    }


    private String thisTurnMoveBridgeInputView() {
        outputView.printChooseWhereToGoBridgeMessage();
        return inputView.readMoving();
    }

    private String bridgeLengthInputView() {
        outputView.gameStartMessage();
        return inputView.readBridgeSize();
    }

    private RetryExitConstant gameRetryOrExitView() {
        outputView.printRetryOrExitGameMessage();
        String exitOrRetry = inputView.readGameCommand();
        return RetryExitConstant.of(exitOrRetry);
    }
}
