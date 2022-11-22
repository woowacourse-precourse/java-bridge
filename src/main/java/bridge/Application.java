package bridge;

import bridge.controller.BridgeGame;
import bridge.service.BridgeService;
import bridge.service.GameService;
import bridge.service.RoundService;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame(new GameService(), new BridgeService(), new RoundService());
        bridgeGame.start();
        bridgeGame.move();
    }
}
