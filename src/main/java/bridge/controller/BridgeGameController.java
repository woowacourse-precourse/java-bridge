package bridge.controller;

import bridge.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private BridgeGame bridgeGame;
    private int tryCount;

    public void startBridgeGame() {
        OutputView.printGameStart();
        int bridgeSize = InputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
        // TODO:
        //  게임 시작

    }
}
