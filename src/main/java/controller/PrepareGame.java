package controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import model.BridgeMaker;
import view.InputView;

import java.util.List;

public class PrepareGame {

    private final InputView inputView = new InputView();
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

    public List<String> prepareGame() {
        int bridgeSize = inputView.setBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> crossAble = bridgeMaker.makeBridge(bridgeSize);
        return crossAble;
    }
}
