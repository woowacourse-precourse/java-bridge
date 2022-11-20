package controller;

import bridge.*;

import java.util.List;

public class BridgeController {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    InputView inputView = new InputView();
    BridgeGame bridgeGame = new BridgeGame();
    OutputView outputView = new OutputView();
    List<String> bridge;

    public void startGame(){
        for(int i = 0; i < bridge.size(); i++){
            String move = inputView.readMoving();
            if(bridgeGame.checkAnswer(bridge.get(i),move)){
                bridgeGame.move(move);
                outputView.printMap();
            }
            if(!bridgeGame.checkAnswer(bridge.get(i),move)){
                bridgeGame.moveFailed(move);
                outputView.printMap();
                askRetryGame();
                break;
            }
        }
    }

    public void makeBridge(){
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        System.out.println("확인용 : " + bridge);
    }

    public void askRetryGame(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        boolean retry = bridgeGame.retry(inputView.readGameCommand());

        if(retry){
            startGame();
        }
        if(!retry){
            outputView.printResult();
        }
    }
}
