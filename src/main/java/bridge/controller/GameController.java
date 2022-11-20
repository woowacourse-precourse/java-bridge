package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.model.BridgeShape;
import bridge.model.GameControll;

import static bridge.controller.GameResultPrint.printGameResult;

public class GameController {

    private static final GameControll gameControll = new GameControll();
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static final BridgeSize bridgeSize = new BridgeSize();
    private static final BridgeMove bridgeMove = new BridgeMove();
    private static final BridgeShape bridgeShape = new BridgeShape();
    private static final BridgeRetry bridgeretry = new BridgeRetry();

    public static void controllMove(){
        if(bridgeSize.getSize() == gameControll.getIdx()){
            gameControll.turnoffGamePower();
            printGameResult();
        }
        if(!(bridgeGame.getCanMove())){
            gameControll.turnoffGamePower();
            bridgeretry.retryBridgeGame();
        }
    }

    public static void retryOrFinish(){
        if(bridgeGame.getDoRetry()){
            gameControll.plusCnt();
            resetGameStatus();
            bridgeMove.movebridge();
        }
        if(!bridgeGame.getDoRetry()){
            printGameResult();
        }
    }

    public static void resetGameStatus(){
        gameControll.initialize();
        bridgeGame.initialize();
        bridgeShape.initializeBridgeShape();
    }

    public static void status(){
        if(gameControll.getIdx() == bridgeSize.getSize()){
            gameControll.turnoffGamePower();
            printGameResult();
        }
        if(!(bridgeGame.getCanMove())){
            gameControll.turnoffGamePower();
            bridgeretry.retryBridgeGame();
        }
    }
}
