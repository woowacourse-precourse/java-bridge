package bridge;

import bridge.controller.BridgeGame;
import bridge.domain.Result;
import bridge.service.BridgeGameService;

import static bridge.domain.Command.*;
import static bridge.domain.Result.*;

public class Application {

    public static void main(String[] args) {
        BridgeGame game = new BridgeGame(new BridgeGameService());
        Result result;

        game.start();

        do {
            result = game.move();
        } while (result.equals(FAIL) && game.retry().equals(RESTART));

        game.finish();
    }
}
