package bridge;

import bridge.controller.BridgeGameController;
import bridge.controller.GameController;
import bridge.service.BridgeNumberGenerator;
import bridge.service.BridgeRandomNumberGenerator;

public class Application {

    public static void main(String[] args) {
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
        GameController game = new BridgeGameController(generator);
        game.start();
    }
}
