package bridge.Controller;

import bridge.Domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.View.InputView;
import bridge.View.OutputView;
import java.util.List;

public class Controller {
    private  InputView inputView;
    private  BridgeNumberGenerator bridgeNumberGenerator;
    private  BridgeMaker bridgeMaker;
    private  OutputView outputView;
    private  BridgeGame bridgeGame;

    public Controller(){
        inputView = new InputView();
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        outputView = new OutputView();
    }

    public void run(){
        bridgeGameInitialization();
        //게임 시작
        boolean gameContinue = true;
        boolean movingSuccess = true;
        while(gameContinue){
            String movingChoice = inputView.readMoving();
            movingSuccess = bridgeGame.move(movingChoice);
            printMovingStatusMap(movingSuccess);
            gameContinue = checkGameContinue(movingSuccess);
        }
        finishBridgeGame(movingSuccess);
    }

    private void bridgeGameInitialization(){
        inputView.printGameStartMessage();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame = new BridgeGame(bridge);
    }

    private void finishBridgeGame(boolean movingSuccess){
        outputView.printGameEndMessage();
        outputView.printMap(bridgeGame.getMyMovingChoices(), movingSuccess, bridgeGame.getMyMovingChoices().size()-1);
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
            String gameCommand = inputView.readGameCommand();
            return bridgeGame.retry(gameCommand);
        }
        return bridgeGame.reachEndPosition();
    }

}
