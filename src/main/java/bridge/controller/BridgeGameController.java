package bridge.controller;

import bridge.BridgeGame;
import bridge.InputView;
import bridge.OutputView;
import bridge.repository.BridgeResultData;

public class BridgeGameController {

    private static final String WIN_GAME = "성공";
    private static final String LOSE_GAME = "실패";

    private int trials = 1;
    private String moving;
    private boolean retry = true;
    private BridgeGame bridgeGame;

    public void run() {
        initialize();
        while (retry) {
            moving();
            if (bridgeGame.movingIsWrong(moving)) {
                retryOrQuit();
            }
            if (bridgeGame.winBridgeGame(moving)) {
                printResult(WIN_GAME);
                break;
            }
        }
    }

    private void initialize() {
        OutputView.printStart();
        makeBridge();
        System.out.println();
    }

    private void makeBridge() {
        try {
            int size = InputView.readBridgeSize();
            bridgeGame = new BridgeGame(size);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            makeBridge();
        }
    }

    private void moving() {
        readMoving();
        bridgeGame.move(moving);
        OutputView.printMap(BridgeResultData.getUpBridgeResults(), BridgeResultData.getDownBridgeResults());
    }

    private void readMoving() {
        try {
            moving = InputView.readMoving();
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            readMoving();
        }
    }

    private void retryOrQuit() {
        readRetry();
        if (retry) {
            bridgeGame.retry();
            trials++;
        }
        if (!retry) {
            printResult(LOSE_GAME);
        }
    }

    private void readRetry() {
        try {
            this.retry = bridgeGame.readRetry(InputView.readGameCommand());
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            readRetry();
        }
    }

    private void printResult(String gameResult) {
        OutputView.printFinalMapMessage();
        OutputView.printMap(BridgeResultData.getUpBridgeResults(), BridgeResultData.getDownBridgeResults());
        OutputView.printResult(gameResult, trials);
        bridgeGame.quit();
    }
}
