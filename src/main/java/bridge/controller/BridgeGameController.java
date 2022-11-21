package bridge.controller;

import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private BridgeGame bridgeGame = new BridgeGame();

    public void start() {
        insertBridge();
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

//    public boolean judgeUserBridgeEnd() {
//        if (bridgeGame.isEndOfBridge()) {
//            return true;
//        }
//
//        return false;
//    }

    public boolean isRetry() {
        String retryMessage = InputView.readGameCommand();
        return bridgeGame.retry(retryMessage);
    }
}
