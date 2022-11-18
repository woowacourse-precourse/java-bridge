package bridge;

import bridge.controller.BridgeController;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        BridgeController bridgeController = new BridgeController();

        List<String> bridge = bridgeController.settingBridge();

        while (true) {
            if (!bridgeController.run(bridge)) {
                break;
            }
        }

        bridgeController.ending(bridge);
    }
}
