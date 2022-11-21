package bridge.Controller;

import bridge.Domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.ArrayList;
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
        inputView.printGameStartMessage();

        //다리 길이 입력 받기
        int bridgeLen = inputView.readBridgeSize();

        //다리 생성하기
        List<String> bridge = bridgeMaker.makeBridge(bridgeLen);

        bridgeGame = new BridgeGame(bridge, bridgeLen);
        //게임 시작

        boolean gameContinue = true;
        while(gameContinue){
            String position = inputView.readMoving();
            boolean gameStatus = bridgeGame.gamePlayOnce(position);
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

        System.out.println("최종 게임 결과");
        outputView.printMap(bridgeGame.mySelectBridge, !gameContinue, bridgeGame.mySelectBridge.size()-1);
        //결과 출력
        outputView.printResult(bridgeGame.gameSuccess, bridgeGame.gameTryCount);
    }

}
