package bridge.controller;

import bridge.*;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
    InputView inputView;
    OutputView outputView;
    BridgeMaker bridgeMaker;
    BridgeNumberGenerator bridgeNumberGenerator;

    BridgeGame bridgeGame;

    List<String> bridge;

    int playerPosition;

    public BridgeController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        playerPosition = 0;
    }

    public void startProgram() {
        outputView.printStartMassage();
        makeBridge();
        bridgeGame = new BridgeGame(bridge);
        crossBridge();


    }

    private void makeBridge() {
        int bridgeSize = readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    private void crossBridge() {
        while(hasNotPassedBridge()) {
            MovePath movePath = inputView.readMoving();
            MoveResult moveResult = bridgeGame.move(movePath, playerPosition);
            if (moveResult == MoveResult.O) {
                playerPosition++;

            }
        }
    }

    private int readBridgeSize() {
        int bridgeSize;
        while (true) {
            try {
                bridgeSize = inputView.readBridgeSize();
                break;
            } catch (IllegalArgumentException e) {
                e.getMessage();
            }
        }
        return bridgeSize;
    }

    private boolean hasNotPassedBridge() {
        return bridge.size() > playerPosition + 1;
    }
}
