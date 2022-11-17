package bridge;

import bridge.businesslogic.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeGame game = new BridgeGame();
        game.initBridgeGame();
        game.play();
    }
}
