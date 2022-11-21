package bridge.controller;

import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private BridgeGame bridgeGame;

    public void start() {
        insertBridge();
        while (insertBridgeToMove()) {

        }
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

}
