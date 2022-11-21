package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeMaker;
import bridge.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class GamePlayer {
    private static final InputView inputView = new InputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private List<String> bridge = new ArrayList<>();
    public void play() {
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        BridgeGame bridgeGame = new BridgeGame();
    }
}
