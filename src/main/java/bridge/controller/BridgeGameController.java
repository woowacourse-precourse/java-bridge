package bridge.controller;

import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private BridgeGame bridgeGame = new BridgeGame();

    public void start() {
        OutputView.printStartGame();
        insertBridge();
        while (cycle());
    }

    public void insertBridge() {
        String length = InputView.readBridgeSize();
        bridgeGame.createBridge(length);
    }

    public boolean cycle() {
        insertBridgeToMove();
        if (judgeUserBridgeSuccess()) {
            finish();
            return false;
        }

        return isRetry();
    }

    public void insertBridgeToMove() {
        while (true) {
            String location = InputView.readMoving();
            bridgeGame.move(location);
            OutputView.printMap(bridgeGame);
            if (judgeUserBridge()) {
                break;
            }
        }
    }

    public boolean judgeUserBridge() {
        if (bridgeGame.isGameSuccess() || !bridgeGame.isGameFail()) {
            return true;

        }
        return false;
    }

    public boolean judgeUserBridgeSuccess() {
        if (bridgeGame.isGameSuccess()) {
            return true;
        }
        return false;
    }

    public boolean isRetry() {
        String retryMessage = InputView.readGameCommand();
        if (bridgeGame.retry(retryMessage)) {
            return true;
        }
        finish();
        return false;
    }

    public void finish() {
        OutputView.printResult(bridgeGame);
    }
}
