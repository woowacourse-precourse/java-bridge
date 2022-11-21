package bridge;

import bridge.domain.BridgeGame;

public class BridgeController {
    private final BridgeGame bridgeGame = new BridgeGame();
    private int size;
    void init(){
        size = bridgeGame.makeBridge();
        run();
    }
    void run(){
        for (int i = 0 ;i<size;i++) {
            bridgeGame.setPlayer();
            bridgeGame.move(i);
        }
        bridgeGame.retry();
    }
}
