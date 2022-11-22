package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputView;
import bridge.OutputView;
import bridge.repository.BridgeResultData;

public class BridgeGameController {

    private static final String WIN_GAME = "성공";
    private static final String LOSE_GAME = "실패";

    private int trials = 1;
    private boolean retry = true;
    private BridgeGame bridgeGame;

    public void run() {
        initialize();
        while (retry) {
            String moving = moving();
            if (bridgeGame.isLose(moving)) {
                retryOrQuit();
            }
            if (bridgeGame.isWin(moving)) {
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
            this.bridgeGame = new BridgeGame(size, new BridgeRandomNumberGenerator());
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            makeBridge();
        }
    }

    private String moving() {
        String moving = readMoving();
        bridgeGame.move(moving);
        OutputView.printMap(BridgeResultData.getUpBridgeResults(), BridgeResultData.getDownBridgeResults());
        return moving;
    }

    private String readMoving() {
        String moving = "";
        try {
            moving = InputView.readMoving();
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            readMoving();
        }
        return moving;
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
