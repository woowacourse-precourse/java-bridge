package bridge;

import bridge.constant.Message;
import bridge.controller.BridgeController;
import bridge.domain.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeController game = new BridgeController();
        game.play();
    }
}
