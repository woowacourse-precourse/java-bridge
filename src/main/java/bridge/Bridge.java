package bridge;

import bridge.controller.InputController;
import bridge.view.OutputView;
import java.util.List;

public class Bridge {

    public static final int INPUT_SIZE = 1;
    public static final int MIN_BRIDGE_SIZE = 3;
    public static final int MAX_BRIDGE_SIZE = 20;

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

    public boolean isSameMoving(int index, Moving moving) {
        return Moving.isSame(bridge.get(index), moving);
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public boolean isEndOfBridge(int index) {
        return index == bridge.size();
    }
}
