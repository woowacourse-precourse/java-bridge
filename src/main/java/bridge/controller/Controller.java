package bridge.controller;

import bridge.domain.BridgeMaker;
import bridge.util.BridgeNumberGenerator;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;

import java.util.List;

public class Controller {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    InputView inputView = new InputView();

    public void start() {
        List<String> temp = bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

}
