package bridge.controller;

import bridge.bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.bridge.BridgeSize;
import bridge.view.InputView;

import java.util.List;

public class BridgeController {
    private int bridgeSize;

    public List<String> bridge() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        BridgeSize bridgeSize = new BridgeSize(InputView.readBridgeSize());
        this.bridgeSize = bridgeSize.getBridgeSize();

        return bridgeMaker.makeBridge(this.bridgeSize);
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
