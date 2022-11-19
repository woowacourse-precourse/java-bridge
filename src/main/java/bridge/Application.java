package bridge;

import bridge.controller.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeGame game = new BridgeGame();
        game.gameStart();
    }
}
