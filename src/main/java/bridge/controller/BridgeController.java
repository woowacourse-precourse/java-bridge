package bridge.controller;

import bridge.*;

import java.util.ArrayList;
import java.util.List;

public class BridgeController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame = new BridgeGame();
    BridgePainter bridgePainter = new BridgePainter();
    
    List bridge;
    boolean success;

    public void startMsg() {
        outputView.printStart();
    }

    public void setBridge() {
        int bridgeLength = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = new ArrayList(bridgeMaker.makeBridge(bridgeLength));
        success = false;
    }

    public void play() {
        while (tryMove(bridge)) {
            bridgeGame.nextStep();
            if (success = bridgeGame.reachTheGoal(bridge, success)) {
                return;
            }
        }
        if (bridgeGame.retry(inputView.readGameCommand())) {
            play();
        }
    }

    public boolean tryMove(List bridge) {
        boolean result = bridgeGame.move(bridge, inputView.readMoving());
        outputView.printMap(bridgePainter.paintBridge(bridge, bridgeGame.getBridgeIdx(), result));
        if (result == false) {
            bridgeGame.setBridgeIdx(0);
        }
        return result;
    }

    public void gameResult() {
        outputView.printResult(bridgePainter.getBridgePainting(), bridgeGame.successOrFail(success), bridgeGame.getTryCount());
    }

    public void run() {
        startMsg();
        setBridge();
        play();
        gameResult();
    }
}