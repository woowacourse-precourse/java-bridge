package bridge;

import bridge.controller.BridgeGameController;
import bridge.view.OutputView;

public class Application {
    private static final BridgeGameController bridgeGameController = new BridgeGameController();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.startGame();
        bridgeGameController.generateBridgeGame();
        bridgeGameController.moveToNext();
    }
}
