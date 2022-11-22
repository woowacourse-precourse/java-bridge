package bridge;

import bridge.controller.BridgeController;

public class Application {
    public static void main(String[] args) {
        BridgeController.startGame();
        while (BridgeController.checkIsGameContinue()) {
            BridgeController.startRound();
            if (BridgeController.checkIsGameFinish()) {
                break;
            }
            BridgeController.restartOrQuitGame();
        }
    }
}
