package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeShape;
import bridge.model.GameControll;
import bridge.service.Valification;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Game {

    private final GameControll gameControll = new GameControll();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private final BridgeShape bridgeShape = new BridgeShape();
    private final InputView inputView = new InputView();
    private final Valification valification = new Valification();
    private final Bridge bridge = new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()));


    private int size;
    private String move;
    private String retryOrQuit;

    public void play() {
        try {
            outputView.printStart();
            viewBridgeSize();
            resetGameStatus();
            gameControll.plusCnt();
            playBridgeGame();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
        }
    }

    private void viewBridgeSize() {
        outputView.printRequestBridgeSize();
        size = inputView.readBridgeSize();
        valification.verifyBridgeSize(size);
        makeBridge();
    }

    private void makeBridge() {
        bridge.setBridge(size);
    }

    private void playBridgeGame() {
        while (gameControll.getGamePower()) {
            viewMove();
            checkMoveBridge();
            makeBirdgeShape();
            showNowBridgeShape();
            gameControll.plusIdx();
            controllMove();
        }
    }

    private void viewMove() {
        outputView.printRequestMove();
        move = inputView.readMoving();
        valification.verifyUorD(move);
    }

    private void checkMoveBridge() {
        bridgeGame.move(move, gameControll.getIdx(), bridge.getBridge());
    }

    private void makeBirdgeShape() {
        bridgeShape.moveBridge(move, bridgeGame.getCanMove());
    }

    private void showNowBridgeShape() {
        outputView.printBridge(bridgeShape.getUpBridge(), bridgeShape.getDownBridge());
    }


    /////
    private void controllMove() {
        if (size == gameControll.getIdx()) {
            gameControll.turnoffGamePower();
            gameControll.sucessGame();
            printGameResult();
        }
        if (!(bridgeGame.getCanMove())) {
            gameControll.turnoffGamePower();
            retry();
        }
    }
    ///////

    private void retry() {
        viewRetry();
        checkRetry();
        retryOrFinish();
    }

    private void viewRetry() {
        outputView.printRequestRetry();
        retryOrQuit = inputView.readGameCommand();
        valification.verifyQorR(retryOrQuit);
    }

    private void checkRetry() {
        bridgeGame.retry(retryOrQuit);
    }

    private void retryOrFinish() {
        if (bridgeGame.getDoRetry()) {
            gameControll.plusCnt();
            resetGameStatus();
            playBridgeGame();
        }
        if (!bridgeGame.getDoRetry()) {
            printGameResult();
        }
    }

    private void resetGameStatus() {
        gameControll.initialize();
        bridgeGame.initialize();
        bridgeShape.initializeBridgeShape();
    }

    private void printGameResult() {
        outputView.printFinalGame();
        showNowBridgeShape();
        outputView.printResult(gameControll.getGameSucess(), gameControll.getCnt());
    }


}
