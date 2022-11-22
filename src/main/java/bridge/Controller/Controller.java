package bridge.Controller;

import bridge.Domain.Bridge;
import bridge.Domain.BridgeGame;
import bridge.Domain.GameCommand;
import bridge.Domain.Moving;
import bridge.View.InputView;
import bridge.View.OutputView;
import java.util.List;

public class Controller {
    private  InputView inputView;
    private  OutputView outputView;
    private  BridgeGame bridgeGame;

    public Controller(){
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run(){
        bridgeGameInitialization();
        boolean gameContinue = true;
        boolean gameClear = gamePlay(gameContinue);
        finishBridgeGame(gameClear);
    }

    private boolean gamePlay(boolean gameContinue){
        boolean movingSuccess = true;
        while(gameContinue){
            String movingChoice = inputView.readMoving();
            Moving moving = new Moving(movingChoice);
            movingSuccess = bridgeGame.move(moving);
            printMovingStatusMap(movingSuccess);
            gameContinue = checkGameContinue(movingSuccess);
        }
        return movingSuccess;
    }

    private void bridgeGameInitialization(){
        inputView.printGameStartMessage();
        String bridgeSize = inputView.readBridgeSize();
        Bridge bridge = new Bridge(bridgeSize);
        bridgeGame = new BridgeGame(bridge);
    }

    private void finishBridgeGame(boolean gameClear){
        outputView.printGameEndMessage();
        outputView.printMap(bridgeGame.getMyMovingChoices(), gameClear, bridgeGame.getMyMovingChoices().size()-1);
        outputView.printResult(bridgeGame.getGameSuccess(), bridgeGame.getGameTryCount());
    }

    private void printMovingStatusMap(boolean movingSuccess){
        if(!movingSuccess){
            //실패한 맵 표시
            outputView.printMap(bridgeGame.getMyMovingChoices(), movingSuccess, bridgeGame.getMyMovingChoices().size()-1);
            return;
        }
        //성공한 맵 표시
        outputView.printMap(bridgeGame.getMyMovingChoices(), movingSuccess, bridgeGame.getMyMovingChoices().size()-1);
    }

    private boolean checkGameContinue(boolean movingSuccess){
        if(!movingSuccess){
            String readGameCommand = inputView.readGameCommand();
            GameCommand gameCommand = new GameCommand(readGameCommand);
            return bridgeGame.retry(gameCommand);
        }
        return bridgeGame.reachEndPosition();
    }

}
