package bridge;

import view.InputView;

import java.util.List;

public class BridgeController {
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator;

    public void run() {
        makeBridgeController();
    }

    public void makeBridgeController() {
        int size = new InputView().readBridgeSize();
        List<String> bridge = new BridgeMaker(bridgeRandomNumberGenerator).makeBridge(size);
    }
}
