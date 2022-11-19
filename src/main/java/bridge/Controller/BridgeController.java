package bridge.Controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.Domain.BridgeMaker;
import java.util.List;

public class BridgeController {

    BridgeMaker bridgeMaker;
    ViewController view;

    public BridgeController() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        view = new ViewController();
    }

    public List<String> getAnswerBridge() {
        int bridgeSize = view.startAndGetBridgeSize();
        return bridgeMaker.makeBridge(bridgeSize);
    }
}
