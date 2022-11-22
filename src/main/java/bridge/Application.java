package bridge;

import bridge.game.Game;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        game.start();
        game.initBridgeGame();
        while (!game.isQuit()) {
            game.playBridgeGame();
            game.isRetry();
        }
        game.end();
    }
}
