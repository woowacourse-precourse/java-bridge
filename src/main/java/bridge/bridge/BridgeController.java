package bridge.bridge;

import bridge.config.BridgeStatus;
import bridge.view.InputView;

import java.util.List;

import static bridge.config.BaseException.INVALID_INPUT;

public class BridgeController {

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private final InputView inputView = new InputView();

    public Bridge createBridge() {
        int size = inputView.readBridgeSize();
        if (3 <= size && size <= 20) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
        Bridge bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        return bridge;
    }

}
