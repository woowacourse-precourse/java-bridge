package bridge;

import bridge.controller.BridgeController;
import bridge.controller.ReadProxyController;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController(new ReadProxyController());
        bridgeController.run();
    }
}
