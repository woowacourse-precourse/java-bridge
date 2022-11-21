package bridge;

import java.util.List;

public class BridgeController {

    private final BridgeView bridgeView;

    public BridgeController(BridgeView bridgeView) {
        this.bridgeView = bridgeView;
    }

    public void start() {
        init();
    }

    private void init() {
        bridgeView.gameStartMessage();
        int bridgeSize = bridgeView.inputBridgeSizeMessage();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridges = bridgeMaker.makeBridge(bridgeSize);
        System.out.println("bridges = " + bridges);
    }
}
