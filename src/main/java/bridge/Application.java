package bridge;

import static bridge.view.InputView.readBridgeSize;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeGameController controller = new BridgeGameController(readBridgeSize());
            controller.runBridgeGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
