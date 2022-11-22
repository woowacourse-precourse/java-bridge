package bridge;

import bridge.game.BridgeGame;
import bridge.game.Game;

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
