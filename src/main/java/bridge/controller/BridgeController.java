package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;

import java.util.List;

public class BridgeController {
    InputView inputView;
    BridgeMaker bridgeMaker;
    BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeController() {
        inputView = new InputView();
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    public void startProgram() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        //이어서 만들기

    }

}
