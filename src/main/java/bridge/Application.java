package bridge;

import bridge.controller.BridgeGame;
import bridge.service.BridgeGameService;

import static bridge.domain.Command.*;
import static bridge.domain.Result.*;

public class Application {

    public static void main(String[] args) {
        BridgeGame game = new BridgeGame(new BridgeGameService());
        game.start();
        while (true) {
            if (game.move().equals(SUCCESS)) {
                break;
            }
            if (game.retry().equals(QUIT)) {
                break;
            }
        }
        game.finish();
    }
}
