package bridge;

import bridge.service.BridgeGame;

public class Controller {

    public void getGame(){
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.startGame();
    }
}
