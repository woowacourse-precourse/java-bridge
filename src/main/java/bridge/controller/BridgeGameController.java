package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.BridgeMaker;
import bridge.domain.GameResult;
import bridge.service.BridgeGame;

import java.util.ArrayList;

import static bridge.view.InputView.readBridgeSize;
import static bridge.view.InputView.readGameCommand;
import static bridge.view.OutputView.printErrorMessage;
import static bridge.view.OutputView.printInputBridgeSizeMessage;

public class BridgeGameController {
    BridgeGame bridgeGame = new BridgeGame();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    Bridge bridge = new Bridge(new ArrayList<>());


    public void start() {
        bridgeExistCheck();
        bridgeGame.retry();
        bridgeGame.move(bridge);

        if (bridgeGame.checkIsGameLose()) {
            if (checkRetry()) {
                start();
            }
        }
    }

    public void end() {
        GameResult finalGameResult = bridgeGame.getFinalGameResult();
        finalGameResult.show();
    }


    private void bridgeExistCheck() {
        if (bridge.isEmpty()) {
            bridge = generateBridge(bridgeMaker);
        }
    }


    private Bridge generateBridge(BridgeMaker bridgeMaker) {
        printInputBridgeSizeMessage();
        Bridge bridge;

        try {
            bridge = new Bridge(bridgeMaker.makeBridge(readBridgeSize()));
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            bridge = generateBridge(bridgeMaker);
        }
        return bridge;
    }


    private boolean checkRetry() {
        boolean isRetry;

        try {
            isRetry = readGameCommand();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            isRetry = checkRetry();
        }
        return isRetry;
    }
}
