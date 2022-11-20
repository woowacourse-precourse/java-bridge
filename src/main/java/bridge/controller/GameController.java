package bridge.controller;

import bridge.InputView;
import bridge.OutputView;
import bridge.service.BridgeGame;
import bridge.support.BridgeMaker;
import bridge.support.BridgeRandomNumberGenerator;

import java.util.List;

public class GameController {
    private final BridgeGame bridgeGame;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public GameController() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = createBridge(bridgeSize);
        this.bridgeGame = new BridgeGame(bridge);
    }

    private List<String> createBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public void play() {

    }

}
