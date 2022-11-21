package bridge.controller;

import bridge.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.utils.constant.Constants.*;

public class BridgeGameController {
    private BridgeGame bridgeGame;
    private int tryCount;

    public void startBridgeGame() {
        OutputView.printGameStart();
        int bridgeSize = InputView.readBridgeSize();
        bridgeGame.makeBridge(bridgeSize);
        // TODO:
        //  게임 시작

    }
}
