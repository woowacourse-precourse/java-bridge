package bridge.controller;

import bridge.domain.Bridge;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeInitializer {

    public static Bridge initialize() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        int bridgeSize = getBridgeSize();
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    private static int getBridgeSize() {
        try {
            OutputView.printBridgeSizeInputMessage();
            return InputView.readBridgeSize();
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return getBridgeSize();
        }
    }
}
