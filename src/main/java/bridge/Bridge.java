package bridge;

import bridge.controller.InputController;
import bridge.view.OutputView;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public static Bridge createBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        int bridgeSize = InputController.getBridgeSize();
        OutputView.formatRow();

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        return new Bridge(bridge);
    }
}
