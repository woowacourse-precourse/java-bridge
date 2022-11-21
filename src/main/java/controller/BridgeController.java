package controller;

import bridge.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class BridgeController {

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private final InputView inputView = new InputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private final OutputView outputView = new OutputView();
    private List<String> bridge;

    public void startGame(){
        bridgeGame.addGameCount();

        if(!isTrySuccess()) {
            askRetryGame();
            return;
        }
        outputView.printResult();
    }

    public boolean isTrySuccess() {
        for (int i = 0; i < bridge.size(); i++) {
            outputView.printMovingSelect();
            String move = inputView.readMoving();

            bridgeGame.checkAnswer(i,move,bridge);
            outputView.printMap();

            if(BridgeGame.getIsPlayerFailed()){
                return false;
            }
        }
        return true;
    }

    public void makeBridge(){
        outputView.printStartMessage();
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    public void askRetryGame(){
        outputView.printRetryMessage();
        boolean retry = bridgeGame.retry(inputView.readGameCommand());

        if(retry){
            bridgeGame.switchResult();
            startGame();
            return;
        }
        outputView.printResult();
    }
}
