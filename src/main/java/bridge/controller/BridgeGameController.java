package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.BridgeMaker;
import bridge.domain.GameBoard;
import bridge.domain.GameResult;
import bridge.domain.MoveResult;
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
            MoveResult moveResult = bridgeGame.move(correctDirection, inputMoveDirection());
            List<GameBoard> gameBoards = bridgeGame.getGameBoards();
            printMap(gameBoards.get(0), gameBoards.get(1));

            if (moveResult.getIsGameLose()) {
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

    private String inputMoveDirection() {
        printInputMoveDirectionMessage();
        String moveDirection;

        try {
            moveDirection = readMoving();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            moveDirection = inputMoveDirection();
        }
        return moveDirection;
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
