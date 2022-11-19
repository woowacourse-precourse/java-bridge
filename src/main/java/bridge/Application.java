package bridge;

import bridge.controller.BridgeGameController;
import bridge.controller.GameController;

public class Application {

    public static void main(String[] args) {
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
        GameController game = new BridgeGameController(generator);
        game.start();
    }
}
