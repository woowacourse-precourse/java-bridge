package bridge;

import bridge.controller.BridgeGame;
import bridge.domain.Game;
import bridge.service.BridgeService;
import bridge.service.GameService;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame(new GameService(), new BridgeService());
        bridgeGame.start();
    }
}
