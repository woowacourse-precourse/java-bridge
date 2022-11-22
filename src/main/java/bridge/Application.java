package bridge;

import bridge.Controller.BridgeController;
import bridge.view.OutputView;

public class Application {
    private static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeController bridgeController = new BridgeController();
        bridgeController.run();
    }
}
