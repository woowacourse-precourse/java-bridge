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
        OutputView.printBridgeSizeInputMessage();
        int bridgeSize = InputView.readBridgeSize();
        OutputView.printBlankLine();
        return bridgeSize;
    }
}
