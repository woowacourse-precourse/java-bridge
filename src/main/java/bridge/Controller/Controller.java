package bridge.Controller;

import bridge.Domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.View.InputView;
import bridge.View.OutputView;
import java.util.List;

public class Controller {
    public InputView inputView;
    public BridgeNumberGenerator bridgeNumberGenerator;
    public BridgeMaker bridgeMaker;
    public OutputView outputView;
    public BridgeGame bridgeGame;

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
        boolean gameStatus = true;
        while(gameContinue){
            String position = inputView.readMoving();
            gameStatus = bridgeGame.gamePlayOnce(position);
            if(!gameStatus){
                //실패한 맵 표시
                outputView.printMap(bridgeGame.mySelectBridge, false, bridgeGame.mySelectBridge.size()-1);
                String gameCommand = inputView.readGameCommand();
                gameContinue = bridgeGame.retry(gameCommand);
                continue;
            }
            //성공한 맵 표시
            outputView.printMap(bridgeGame.mySelectBridge, true, bridgeGame.mySelectBridge.size()-1);
            gameContinue = bridgeGame.move();
        }

        finishBridgeGame(gameStatus);
    }

    public void bridgeGameInitialization(){
        inputView.printGameStartMessage();
        int bridgeLen = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeLen);
        bridgeGame = new BridgeGame(bridge);
    }



    public void finishBridgeGame(boolean gameStatus){
        System.out.println("최종 게임 결과");
        outputView.printMap(bridgeGame.mySelectBridge, gameStatus, bridgeGame.mySelectBridge.size()-1);
        outputView.printResult(bridgeGame.gameSuccess, bridgeGame.gameTryCount);
    }

}
