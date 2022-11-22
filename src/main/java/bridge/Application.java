package bridge;

import bridge.controller.BridgeController;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeController.run();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }
}
