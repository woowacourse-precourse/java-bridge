package bridge.bridge;

import bridge.view.InputView;

public class BridgeController {

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private final InputView inputView = new InputView();

    public void createBridge() {

        int size = inputView.readBridgeSize();

        bridgeMaker.makeBridge(size);

    }

}
