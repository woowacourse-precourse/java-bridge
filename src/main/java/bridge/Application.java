package bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGameController bridgeGameController = new BridgeGameController(bridgeMaker);

        try {
            bridgeGameController.initBridgeGame();
            bridgeGameController.playBridgeGame();
            bridgeGameController.printFinalResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
