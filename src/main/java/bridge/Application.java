package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.Result;

public class Application {

    public static void main(String[] args) {
        BridgeGame game = new BridgeGame();
        game.start();
        while (true) {
            if (game.move().equals(Result.SUCCESS)) {
                break;
            }
        }
    }
}
