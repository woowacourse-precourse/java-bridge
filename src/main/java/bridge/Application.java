package bridge;

import bridge.controller.BridgeGame;
import bridge.model.Bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = new BridgeGame();
        Bridge bridge = new Bridge(Bridge.makeBridge());
        bridgeGame.playGame(bridge);
    }
}
