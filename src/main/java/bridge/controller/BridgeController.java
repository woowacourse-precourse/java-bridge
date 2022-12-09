package bridge.controller;

import bridge.*;

import java.util.ArrayList;
import java.util.List;

public class BridgeController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    List bridge = new ArrayList();
    BridgeGame bridgeGame = new BridgeGame();
    BridgePainter bridgePainter;
    boolean retry = true;
    boolean success;

    public void run() {
        startGame();
        generateBridge();
        crossing();
        finalResult();
    }

    private void startGame() {
        outputView.printStartMsg();
    }

    private void generateBridge() {
        int bridgeLength = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(bridgeLength);
    }

    private void crossing() {
        int currentSpot = 0;
        while (currentSpot != bridge.size()) {
            currentSpot = move(currentSpot);
            if (!success) {
                retry = bridgeGame.retry(inputView.readGameCommand());
            }
            if (!retry) break;
        }
    }

    private int move(int currentSpot) {
        inputAndMove(currentSpot);
        buildAndPrintBridge(currentSpot);
        if(!success) {
            currentSpot = 0;
            return currentSpot;
        }
        currentSpot++;
        return currentSpot;
    }

    private void inputAndMove(int currentSpot) {
        bridgePainter = new BridgePainter();
        String upOrDown = inputView.readMoving();
        success = bridgeGame.move(bridge, currentSpot, upOrDown);
    }

    private void buildAndPrintBridge(int currentSpot) {
        bridgePainter.paint(bridge, currentSpot, success);
        outputView.printMap(bridgePainter);
    }

    private void finalResult() {
        String successOrFail = bridgeGame.successOrFail(success);
        outputView.printResult(bridgePainter, successOrFail, bridgeGame.getTryCount());
    }

}
