package bridge.Model;

import bridge.Controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController();
        try {
            bridgeGameController.gameStart();
        } catch (Exception e) {
            System.out.println("[ERROR]");
        }
    }
}
