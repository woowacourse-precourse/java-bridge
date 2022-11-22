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
        try {
            OutputView.printStartMessage();
            BridgeSizeRequest bridgeSizeRequest = InputView.readBridgeSize();
            bridgeGame = new BridgeGame(bridgeSizeRequest);
            startGame();
            showResult();
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
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
        MoveRequest moveRequest = InputView.readMoving();
        ScoreMap scoreMap = bridgeGame.move(moveRequest);
        OutputView.printMap(scoreMap);
    }

    private void showResult() {
        GameResult gameResult = bridgeGame.getResultOfGame();
        OutputView.printResult(gameResult);
    }

    private void askRetry() {
        GameRequest gameRequest = InputView.readGameCommand();
        if (gameRequest.wantRetry()) {
            bridgeGame.retry();
            startGame();
        }
    }

}
