package bridge.Controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.Domain.BridgeMaker;
import bridge.View.TotalView;
import java.util.List;

public class BridgeController {

    private final BridgeMaker bridgeMaker;
    private final TotalView view;

    public BridgeController() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        view = new TotalView();
    }

    public List<String> getAnswerBridge() {
        int bridgeSize = view.startAndGetBridgeSize();
        return bridgeMaker.makeBridge(bridgeSize);
    }
}
