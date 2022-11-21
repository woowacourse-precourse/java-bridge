package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.view.InputView;

import java.util.List;

public class BridgeGameInitializer {
    private static final int DEFAULT_TRY_COUNT = 1;
    private static final InputView inputView = InputView.getInstance();

    private BridgeGameInitializer() {
    }

    public static BridgeGame initializeBridgeGame() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return new BridgeGame(bridge, DEFAULT_TRY_COUNT);
    }
}
