package bridge;

import bridge.controller.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        try {
            bridgeGame.Run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
