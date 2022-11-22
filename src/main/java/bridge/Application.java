package bridge;

import game.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameManager = new BridgeGameController();
        bridgeGameManager.startGame();
    }

}
