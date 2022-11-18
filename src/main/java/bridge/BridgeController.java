package bridge;

import view.InputView;
import view.OutputView;

import java.util.List;

public class BridgeController {
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator;

    public void run() {
        new OutputView().printStart();
        makeBridgeController();
    }

    public void makeBridgeController() {
        int size = new InputView().readBridgeSize();
        List<String> bridge = new BridgeMaker(bridgeRandomNumberGenerator).makeBridge(size);
        for (int blockCount = 0; blockCount < size; blockCount++) {
            moveController(bridge, blockCount);
        }
    }

    public void moveController(List<String> bridge, int blockCount) {
        String sideToMove = new InputView().readMoving();
        new BridgeGame().move(sideToMove, bridge, blockCount);
    }
}
