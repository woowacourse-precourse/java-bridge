package bridge.exception;

import bridge.BridgeGame;
import bridge.BridgeInit;

import java.util.List;

public class BridgeService {

    private int attemp;
    private final BridgeInit bridgeInit;
    private final BridgeGame bridgeGame;
    private final List<String> bridge;

    BridgeService(BridgeInit bridgeInit, BridgeGame bridgeGame){
        attemp = 0;
        this.bridgeGame = bridgeGame;
        this.bridgeInit = bridgeInit;
        bridge = bridgeInit.makeGame();
    }

    public void gameStart(){
        attemp++;

    }
}
