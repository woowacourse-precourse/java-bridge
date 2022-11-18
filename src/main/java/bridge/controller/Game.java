package bridge.controller;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.view.InputView;

import java.util.List;

public class Game {
    private InputView inputView;
    private BridgeMaker bridgeMaker;

    public Game() {
        inputView = new InputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void play() {
        int input = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(input);
    }
}
