package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;

import java.util.List;

public class BridgeGameController {
    private BridgeGame bridgeGame;

    public void start() {

    }

    private void set() {
        int size = Integer.parseInt(InputView.readBridgeSize());
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(size));
    }
}
