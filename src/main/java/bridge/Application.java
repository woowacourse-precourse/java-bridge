package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        int bridgeSize = bridgeGame.startGame();
        List<String> bridge = bridgeGame.makeBridge(bridgeSize);
        System.out.println(bridge);

        bridgeGame.move(bridge);



    }
}
