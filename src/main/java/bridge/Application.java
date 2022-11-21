package bridge;

import bridge.domain.BridgeGame;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeGame game = new BridgeGame();
            game.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
