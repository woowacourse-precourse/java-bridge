package bridge;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();

        bridgeGame.gameSet();
        do {
            bridgeGame.play();
        } while (bridgeGame.retry());
    }
}
