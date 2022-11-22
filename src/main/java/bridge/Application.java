package bridge;

import bridge.controller.BridgeGame;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            BridgeGame bridgeGame = new BridgeGame();
            bridgeGame.playGame(bridgeGame.makeBridge());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
