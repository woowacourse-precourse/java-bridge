package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.model.BridgeMaker;

public class BridgeController {

    private final BridgeMaker bridgeMaker;

    public BridgeController(BridgeNumberGenerator bridgeNumberGenerator){
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }
}
