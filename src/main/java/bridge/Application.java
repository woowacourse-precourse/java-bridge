package bridge;

import bridge.controller.BridgeController;
import bridge.utils.message.ErrorMessage;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeController bridgeController = new BridgeController();
            bridgeController.startGame();
            bridgeController.playGame();
        } catch (IllegalArgumentException exception) {
            System.out.println(ErrorMessage.EXIT.getMessage());
        }
    }
}
