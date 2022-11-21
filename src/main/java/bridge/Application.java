package bridge;

import bridge.controller.BridgeGameController;
import bridge.service.BridgeService;
import bridge.service.GameService;

public class Application {

    public static void main(String[] args) {
        BridgeGameController controller = new BridgeGameController(
                new BridgeService(),
                new GameService());

        controller.run();
    }
}
