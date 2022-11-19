package controller;

import bridge.*;

import java.util.List;
import java.util.StringJoiner;

public class BridgeController {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    InputView inputView = new InputView();
    BridgeGame bridgeGame = new BridgeGame();
    OutputView outputView = new OutputView();
    List<String> bridge;

    public void startGame(){
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());

        for(int i = 0; i < 3; i++){
            String move = inputView.readMoving();
            if(bridgeGame.checkAnswer(bridge.get(i),move)){
                System.out.println("정답");
            }
            outputView.printMap();
        }
    }
}
