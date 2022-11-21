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

            moveingControl(i,move);

            if(BridgeGame.getIsPlayerFailed()){
                return false;
            }
        }
        return true;
    }

    public void moveingControl(int moveingIndex, String move){
        if (bridgeGame.checkAnswer(bridge.get(moveingIndex), move)) {
            bridgeGame.move(move);
        }
        if (!bridgeGame.checkAnswer(bridge.get(moveingIndex), move)) {
            bridgeGame.moveFailed(move);
            bridgeGame.switchResult();
        }
        outputView.printMap();
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
        outputView.printMap();
    }
}
