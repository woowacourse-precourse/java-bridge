package bridge;

import java.util.List;

public class BridgeGameController {
    public static void run() {
        int bridgeSize = inputBridgeSize();
        List<String> bridge = createBridge(bridgeSize);
    }

    private static int inputBridgeSize() {
        try {
            return InputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBridgeSize();
        }
    }

    private static List<String> createBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }
}
