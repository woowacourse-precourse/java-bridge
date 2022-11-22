package bridge;

import bridge.Controller.BridgeController;
import bridge.Controller.GameController;
import bridge.Model.Bridge;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController();
        GameController gameController = new GameController();

        try {
            Bridge bridge = bridgeController.generate();
            gameController.run(bridge);
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }
    }
}
