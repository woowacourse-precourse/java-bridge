package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {
    private BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;
    private InputView inputView;
    private OutputView outputView;
    private List<String> bridge;

    private List<String> upBridge;
    private List<String> downBridge;

    private int stage;

    public void init() {
        stage = inputView.readBridgeSize();
        outputView.printGameStart();
        bridge = bridgeMaker.makeBridge(stage);
    }
}
