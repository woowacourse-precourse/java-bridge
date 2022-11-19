package bridge;

import bridge.Domain.BridgeGame;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeGame game = new BridgeGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
