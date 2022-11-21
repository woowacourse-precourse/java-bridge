package bridge;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        play();
    }

    private static void play() {
        BridgeGame bridgeGame = new BridgeGame();
        List<String> bridge;

        OutputView.printStartMessage();
        bridge = bridgeBundle();
        moveOrRetry(bridgeGame, bridge);
        OutputView.printResult(bridgeGame);
    }
}
