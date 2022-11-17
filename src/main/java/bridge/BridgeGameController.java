package bridge;

import java.util.List;

public class BridgeGameController {
    public static void run() {
        int bridgeSize = inputBridgeSize();
    }

    private static int inputBridgeSize() {
        try {
            return InputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBridgeSize();
        }
    }
}
