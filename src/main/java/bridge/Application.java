package bridge;

import bridge.controller.BridgesController;
import bridge.view.OutputView;

public class Application {

    private static final BridgesController bridgesController = new BridgesController();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.startGame();
        bridgesController.generateBridge();
    }
}
