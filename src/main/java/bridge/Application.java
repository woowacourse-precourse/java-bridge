package bridge;

import java.util.List;

public class Application {
    private static final InputView inputView = InputView.getInstance();
    private static BridgeMaker bridgeMaker;
    private static final BridgeGame bridgeGame = BridgeGame.getInstance();

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        int bridgeSize = inputView.readBridgeSize();
        constructBridge(bridgeSize);
    }

    private static List<String> constructBridge(int bridgeSize) {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }
}
