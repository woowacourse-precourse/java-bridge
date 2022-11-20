package bridge.domain;

import bridge.model.BridgeShape;
import bridge.model.GameControll;

public class ResetGame {

    private final GameControll gameControll;
    private final BridgeGame bridgeGame;
    private final BridgeShape bridgeShape;

    ResetGame(GameControll gameControll, BridgeGame bridgeGame, BridgeShape bridgeShape){
        this.gameControll = gameControll;
        this.bridgeGame = bridgeGame;
        this.bridgeShape = bridgeShape;
    }

    public void resetGameStatus(){
        gameControll.initialize();
        bridgeGame.initialize();
        bridgeShape.initializeBridgeShape();

    }
}
