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

    public void startGame() {
        bridgeGame.addGameCount();
        for (int i = 0; i < bridge.size(); i++) {
            outputView.printMovingSelect();
            moveOneStep(i,inputView.readMoving(),bridge);
            if (BridgeGame.getIsPlayerFailed()) {
                askRetryGame();
                return;
            }
        }
        outputView.printResult();
    }

    public void moveOneStep(int bridgeIndex,String move,List<String> bridge) {
        if(bridge.get(bridgeIndex).equals(move)){
            bridgeGame.move(move);
        }
        if(!bridge.get(bridgeIndex).equals(move)){
            bridgeGame.moveFailed(move);
            bridgeGame.switchResult();
        }
        outputView.printMap();
    }

    public void makeBridge() {
        outputView.printStartMessage();
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    public void askRetryGame() {
        outputView.printRetryMessage();
        boolean retry = bridgeGame.retry(inputView.readGameCommand());

        if (retry) {
            bridgeGame.switchResult();
            startGame();
            return;
        }
        outputView.printResult();
    }
}
