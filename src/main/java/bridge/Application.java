package bridge;

import bridge.controller.BridgeGame;
import bridge.controller.Game;

public class Application {

    public static void main(String[] args) {
        try {
            Game game = new BridgeGame();
            game.play();
            game.showResult();
        } catch (IllegalArgumentException ignored) {
        }
    }
}
