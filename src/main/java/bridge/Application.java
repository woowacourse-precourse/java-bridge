package bridge;

import bridge.controller.BridgeController;
import bridge.enums.GameCommand;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController(new BridgeRandomNumberGenerator());
    }
}
