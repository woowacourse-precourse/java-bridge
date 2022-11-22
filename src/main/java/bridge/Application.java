package bridge;

import java.util.EnumMap;
import java.util.List;

public class Application {
    private static final InputView inputView = InputView.getInstance();

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = constructBridge(bridgeSize);

        play(bridge);
    }

    private static List<String> constructBridge(int bridgeSize) {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private static void play(List<String> bridge) {
        String moveChoice = inputView.readMoving();
    }
}
