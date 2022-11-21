package bridge;

import bridge.controller.BridgeGame;

public class Application {
    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        try {
            bridgeGame.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

