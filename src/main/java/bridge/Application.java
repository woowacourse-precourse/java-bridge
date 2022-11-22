package bridge;

import java.util.NoSuchElementException;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeGame bridgeGame = new BridgeGame();
            bridgeGame.start();
            bridgeGame.loop();
            bridgeGame.finish();
        } catch (NoSuchElementException e) {
            System.out.println("[ERROR]" + e.getMessage());
        }
    }
}
