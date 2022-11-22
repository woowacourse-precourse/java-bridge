package controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeMaker;
import view.InputView;

import java.util.List;

public class PrepareGame {

    private final int bridgeSize;

    private final InputView inputView = new InputView();
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

    public PrepareGame(int bridgeSize) {
        this.bridgeSize = bridgeSize;
    }

    public List<String> prepareGame() {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> crossAble = bridgeMaker.makeBridge(bridgeSize);
        return crossAble;
    }
}
