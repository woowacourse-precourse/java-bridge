package bridge.controller;

import static bridge.domain.enums.Status.*;

import bridge.controller.request.BridgeSizeRequest;
import bridge.controller.request.GameRequest;
import bridge.controller.request.MoveRequest;
import bridge.domain.model.GameResult;
import bridge.domain.model.ScoreMap;
import bridge.domain.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private BridgeGame bridgeGame;

    public void run() {

        OutputView.printStartMessage();
        inputBridge();
        startGame();
        showResult();

    }

    private void inputBridge() {
        try {
            BridgeSizeRequest bridgeSizeRequest = InputView.readBridgeSize();
            bridgeGame = new BridgeGame(bridgeSizeRequest);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            inputBridge();
        }
    }

    private void startGame() {
        while (!bridgeGame.isGameOver()) {
            showProcess();
        }
        if (bridgeGame.getStatus() == FAIL_STATUS) {
            askRetry();
        }
    }

    private void showProcess() {
        try {
            MoveRequest moveRequest = InputView.readMoving();
            ScoreMap scoreMap = bridgeGame.move(moveRequest);
            OutputView.printMap(scoreMap);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
        }
    }

    private void showResult() {
        GameResult gameResult = bridgeGame.getResultOfGame();
        OutputView.printResult(gameResult);
    }

    private void askRetry() {
        try {
            GameRequest gameRequest = InputView.readGameCommand();
            if (gameRequest.wantRetry()) {
                bridgeGame.retry();
                startGame();
            }
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            askRetry();
        }

    }

}
