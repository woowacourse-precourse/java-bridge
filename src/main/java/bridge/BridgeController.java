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
        moveController(bridge);
    }

    public void moveController(List<String> bridge) {
        String sideToMove = new InputView().readMoving();
        StringBuilder initialBridge = new BridgeMaker(bridgeRandomNumberGenerator).makeInitialBridge();
        initialBridge = new BridgeGame().move(bridge, sideToMove, initialBridge);
    }
}
