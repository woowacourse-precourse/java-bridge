package bridge;

import bridge.client.Client;
import bridge.controller.BridgeController;
import bridge.controller.GameController;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController();
        GameController gameController = new GameController();
        Client client = new Client(bridgeController, gameController);

        client.run();
    }
}
