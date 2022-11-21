package bridge.controller;

import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private static boolean cycleCheck = true;
    private static int tryCount = 0;
    private BridgeGame bridgeGame = new BridgeGame();

    public void start() {
        insertBridge();
        while (cycleCheck) {
            cycleCheck = checkGameCycle();
        }
    }

    public boolean checkGameCycle() {
        while (insertBridgeToMove()) {
            if (judgeUserBridgeEnd()) {
                break;
            }
        }
        return isRetry();
    }

    public void insertBridge() {
        String length = InputView.readBridgeSize();
        bridgeGame.createBridge(length);
    }

    public boolean insertBridgeToMove() {
        String location = InputView.readMoving();
        bridgeGame.move(location);
        return OutputView.printMap(bridgeGame.getUserBridge(), bridgeGame.getComputerBridge().getBridgeLast());
    }

    public boolean judgeUserBridgeEnd() {
        if (bridgeGame.isEndOfBridge()) {
            return true;
        }

        return false;
    }

    public boolean isRetry() {
        String retryMessage = InputView.readGameCommand();
        return bridgeGame.retry(retryMessage);
    }
}
