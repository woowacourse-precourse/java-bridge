package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeShape;
import bridge.domain.GameStatus;
import bridge.view.InputView;
import bridge.view.OutputView;


public class GameControll {

    private final InputView inputView;
    private final OutputView outputView;
    private final static GameStatus GAME_STATUS = new GameStatus();
    private final static BridgeGame bridgeGame = new BridgeGame();
    private final static BridgeShape bridgeShape = new BridgeShape();
    private final static Bridge bridge = new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()));

    public GameControll(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private int size;
    private String move;
    private String retryOrQuit;

    public void play() {

            outputView.printStart();
            viewBridgeSize();
            resetGameStatus();
            GAME_STATUS.plusCnt();
            playBridgeGame();

    }

    private void viewBridgeSize(){
        inputBridgeSize();
    }
    private void inputBridgeSize() {
        size = inputView.readBridgeSize();
        makeBridge();
    }

    private void makeBridge() {
        bridge.setBridge(size);
    }

    private void playBridgeGame() {
        while (GAME_STATUS.getGamePower()) {
            viewMove();
            checkMoveBridge();
            makeBirdgeShape();
            showNowBridgeShape();
            GAME_STATUS.plusIdx();
            controllMove();
        }
    }

    private void viewMove() {
        move = inputView.readMoving();
    }

    private void checkMoveBridge() {
        bridgeGame.move(move, GAME_STATUS.getIdx(), bridge.getBridge());
    }

    private void makeBirdgeShape() {
        bridgeShape.moveBridge(move, bridgeGame.getCanMove());
    }

    private void showNowBridgeShape() {
        outputView.printBridge(bridgeShape.getUpBridge(), bridgeShape.getDownBridge());
    }


    /////
    private void controllMove() {
        if (size == GAME_STATUS.getIdx() && bridgeGame.getCanMove()) {
            GAME_STATUS.turnoffGamePower();
            GAME_STATUS.sucessGame();
            printGameResult();
        }
        if (!(bridgeGame.getCanMove())) {
            GAME_STATUS.turnoffGamePower();
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
        retryOrQuit = inputView.readGameCommand();
    }

    private void checkRetry() {
        bridgeGame.retry(retryOrQuit);
    }

    private void retryOrFinish() {
        if (bridgeGame.getDoRetry()) {
            GAME_STATUS.plusCnt();
            resetGameStatus();
            playBridgeGame();
        }
        if (!bridgeGame.getDoRetry()) {
            printGameResult();
        }
    }

    private void resetGameStatus() {
        GAME_STATUS.initialize();
        bridgeGame.initialize();
        bridgeShape.initializeBridgeShape();
    }

    private void printGameResult() {
        outputView.printFinalGame();
        showNowBridgeShape();
        outputView.printResult(GAME_STATUS.getGameSucess(), GAME_STATUS.getCnt());
    }


}
