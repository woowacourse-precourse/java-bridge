package controller;

import bridge.*;
import view.InputView;
import view.OutputView;

public class BridgeController {

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private final InputView inputView = new InputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private final OutputView outputView = new OutputView();
    private Bridge bridge;

    public void startGame() {
        bridgeGame.addGameCount();
        for (int i = 0; i < bridge.getBridgeSize(); i++) {
            outputView.printMovingSelect();
            moveOneStep(i,inputView.readMoving(),bridge);
            if (BridgeGame.getIsPlayerFailed()) {
                askRetryGame(inputView.readGameCommand());
                return;
            }
        }
        outputView.printResult();
    }

    public void moveOneStep(int bridgeIndex,String move,Bridge bridge) {
        if(bridge.correctStep(bridgeIndex, move)){
            bridgeGame.move(move);
        }
        if(!bridge.correctStep(bridgeIndex, move)){
            bridgeGame.moveFailed(move);
            bridgeGame.switchResult();
        }
        outputView.printMap();
    }

    public void makeBridge() {
        outputView.printStartMessage();
        bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }

    public void askRetryGame(String selectRetry) {
        outputView.printRetryMessage();
        boolean retry = bridgeGame.retry(selectRetry);

        if (retry) {
            bridgeGame.switchResult();
            startGame();
            return;
        }
        outputView.printResult();
    }
}
