package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {

    BridgeGame bridgeGame;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    public void gameInit() {
        outputView.gameStart();
        int size = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);
        bridgeGame = new BridgeGame(bridge);
    }

    void movePlayer() {
    }
}
