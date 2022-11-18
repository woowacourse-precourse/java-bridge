package bridge;

import bridge.controller.BridgeController;
import bridge.view.OutputView;

public class Application {

    private static final BridgeController bridgesController = new BridgeController();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.startGame();
        bridgesController.generateBridge();
    }
}
