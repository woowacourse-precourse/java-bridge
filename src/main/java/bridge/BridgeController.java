package bridge;

import bridge.domain.BridgeGame;

public class BridgeController {
    private final BridgeGame bridgeGame = new BridgeGame();
    void init(){
        bridgeGame.makeBridge();
        run();
    }
    void run(){
        bridgeGame.setPlayer();
        bridgeGame.move();
        bridgeGame.retry();
    }
}
