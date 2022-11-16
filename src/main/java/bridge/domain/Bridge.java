package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;

import java.util.List;

public class Bridge {

    private final Integer bridgeSize;
    private final List<String> bridge;
    private InputView inputView = new InputView();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public Bridge() {
        this.bridgeSize = inputView.readBridgeSize();
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public Integer getBridgeSize() {
        return bridgeSize;
    }

    public List<String> getBridge() {
        return bridge;
    }
}
