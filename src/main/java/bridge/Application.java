package bridge;

import bridge.controller.BridgeGame;
import bridge.domain.Command;
import bridge.domain.Result;
import bridge.service.BridgeGameService;

public class Application {

    public static void main(String[] args) {
        BridgeGame game = new BridgeGame(new BridgeGameService());
        game.start();
        while (true) {
            if (game.move().equals(Result.SUCCESS)) {
                break;
            }
            if (game.retry().equals(Command.QUIT)) {
                break;
            }
        }
        game.finish();
    }
}
