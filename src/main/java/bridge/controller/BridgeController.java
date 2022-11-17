package bridge.controller;

import bridge.domain.BridgeMaker;
import bridge.domain.generator.BridgeRandomNumberGenerator;

import java.util.List;

import static bridge.view.InputView.*;

public class BridgeController {
    private final BridgeMaker bridgeMaker;

    public BridgeController(BridgeRandomNumberGenerator bridgeRandomNumberGenerator){
        this.bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    }

    public void start() {
        List<String> bridge = bridgeMaker.makeBridge(readBridgeSize().getBridgeSize());

    }
}
