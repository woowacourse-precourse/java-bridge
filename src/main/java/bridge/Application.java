package bridge;

import bridge.service.BridgeGame;
import bridge.service.BridgeGameConsole;

public class Application {

    public static void main(String[] args) {
        BridgeGameConsole console = new BridgeGameConsole();
        console.gameStartMessage();

        BridgeGame game = new BridgeGame();
        game.start();
        game.end();
    }
}
