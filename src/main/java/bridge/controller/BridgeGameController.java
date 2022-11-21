package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.BridgeMaker;
import bridge.domain.GameBoard;
import bridge.domain.GameResult;
import bridge.service.BridgeGame;

import java.util.ArrayList;
import java.util.List;

import static bridge.view.InputView.*;
import static bridge.view.OutputView.*;

public class BridgeGameController {
    BridgeGame bridgeGame = new BridgeGame();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    Bridge bridge = new Bridge(new ArrayList<>());


    public void start() {
        bridgeExistCheck();
        bridgeGame.resetGameValue();
        moveOnBridge();
        retryCheckWhenGameLose();
    }

    private void moveOnBridge() {
        for (String correctDirection : bridge.getBridge()) {
            boolean isGameLose = bridgeGame.move(correctDirection, inputMovingDirection());
            List<GameBoard> gameBoards = bridgeGame.getGameBoards();
            printMap(gameBoards.get(0), gameBoards.get(1));

            if (isGameLose) {
                break;
            }
        }
    }

    private void retryCheckWhenGameLose() {
        if (bridgeGame.checkIsGameLose()) {
            if (checkRetry()) {
                bridgeGame.retry();
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

    private String inputMovingDirection() {
        printInputMovingDirectionMessage();
        String movingDirection;

        try {
            movingDirection = readMoving();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            movingDirection = inputMovingDirection();
        }
        return movingDirection;
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
