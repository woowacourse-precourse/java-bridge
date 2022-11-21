package bridge.domain;

import bridge.Application;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Initialization {

    public static BridgeGame init() {
        OutputView.printStart();
        inputBridgeSize();
        createBridge();
        return new BridgeGame();
    }

    public static void inputBridgeSize() {
        OutputView.printRequestSize();
        Application.size = InputView.readBridgeSize();
    }

    public static void createBridge() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        Application.bridge = bridgeMaker.makeBridge(Application.size);
    }

}
