package bridge.domain;

import bridge.Application;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Initialization {

    public static int init() {
        OutputView.printStart();
        OutputView.printRequestSize();
        int size = InputView.readBridgeSize();
        createBridge(size);
        Application.totalTrial = 1;
        return size;
    }

    public static void createBridge(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        Application.bridge = bridgeMaker.makeBridge(size);
    }

}
