package bridge;

public class Initialization {

    public static void init() {
        OutputView.printStart();
        selectBridgeSize();
        createBridge();
    }

    public static void selectBridgeSize() {
        OutputView.printRequestSize();
        Application.size = InputView.readBridgeSize();
    }

    public static void createBridge() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        Application.bridge = bridgeMaker.makeBridge(Application.size);
    }

}
