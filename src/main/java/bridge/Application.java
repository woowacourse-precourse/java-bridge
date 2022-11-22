package bridge;

import java.util.List;

public class Application {

    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();

    private static int getBridgeSize() {
        outputView.guideBridgeSizeInput();
        return inputView.readBridgeSize();
    }

    private static List<String> getBridge(int bridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        return new BridgeMaker(bridgeNumberGenerator).makeBridge(bridgeSize);
    }

    public static void main(String[] args) {
        outputView.guideStart();
        int bridgeSize = getBridgeSize();
        List<String> bridge = getBridge(bridgeSize);
        GameRunner gameRunner = new GameRunner(bridge);
        gameRunner.run();
    }
}