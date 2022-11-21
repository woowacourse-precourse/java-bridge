package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeShape;
import bridge.domain.GameStatus;
import bridge.view.InputView;
import bridge.view.OutputView;


public class Game {

    private final InputView inputView;
    private final OutputView outputView;
    private final static GameStatus GAME_STATUS = new GameStatus();
    private final static BridgeGame bridgeGame = new BridgeGame();
    private final static BridgeShape bridgeShape = new BridgeShape();
    private final static Bridge bridge = new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()));

    public Game(InputView inputView, OutputView outputView){
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

    private void inputBridgeSize() {
        outputView.printRequestBridgeSize();
        size = inputView.readBridgeSize();
        makeBridge();
    }

    private void viewBridgeSize(){
        while(true){
            try{
                inputBridgeSize();
                break;
            }catch(IllegalArgumentException exception){
                outputView.printErrorMessage(exception.getMessage());
            }
        }
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
        while(true){
            try{
                outputView.printRequestMove();
                move = inputView.readMoving();
                break;
            }catch(IllegalArgumentException exception){
                outputView.printErrorMessage(exception.getMessage());
            }
        }
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
        while(true){
            try {
                outputView.printRequestRetry();
                retryOrQuit = inputView.readGameCommand();
                break;
            }catch(IllegalArgumentException exception){
                outputView.printErrorMessage(exception.getMessage());
            }
        }
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
