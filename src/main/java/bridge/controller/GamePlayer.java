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
    private final BridgeGame bridgeGame = new BridgeGame();
    public void play() {
        this.bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        this.bridgeGame.setBridge(bridge);
        crossingBridge();
    }
    private void crossingBridge() {
        for(int i = 0; i < this.bridge.size(); i++) {
            this.bridgeGame.move(inputView.readMoving());
        }
    }
}
