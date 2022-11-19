package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.bridge.BridgeGame;
import bridge.domain.bridge.BridgeSize;
import bridge.view.InputView;

import java.util.List;

public class MainController {
    public static void run() {
        BridgeSize bridgeSize = new BridgeSize(InputView.readBridgeSize());
        BridgeGame bridgeGame = makeBridgeGame(bridgeSize.get());
    }

    public static BridgeGame makeBridgeGame(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);
        return new BridgeGame(bridge);
    }
}
