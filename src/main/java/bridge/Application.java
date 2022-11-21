package bridge;

import static bridge.Constants.StandardTools.SUCCEED;

import bridge.Constants.StandardTools.retry;
import bridge.Domain.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeGame game = new BridgeGame();
        game.gameStart();
        while (game.getRetryOrQuit() == retry.RETRY || (game.getIsGameSucceed() != SUCCEED
                && !game.getIsGameFinished())) {
            game.move();
        }
    }

}
