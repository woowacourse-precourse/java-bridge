package bridge.controller;

import bridge.model.*;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    BridgeGame bridgeGame;

    InputView iv;
    OutputView ov;

    public BridgeGameController() {
        this.bridgeGame = new BridgeGame();
        this.iv = new InputView();
        this.ov = new OutputView();
    }

    public void run() {
        ov.gameStart();
        makeBridge();
        playGame();
        printResult();
    }

    private void makeBridge() {
        retryTask(() -> {
            bridgeGame.makeBridge(iv.readBridgeSize());
        });
    }

    private void playGame() {
        do {
            retryTask(() -> {
                bridgeGame.move(iv.readMoving());
            });
            bridgeGame.makeMap(bridgeGame.getBridge(), bridgeGame.getMarks());
            ov.printMap(bridgeGame.getMap());
            if (quit()) {
                break;
            }
        } while (bridgeGame.isEndOfBridge());
    }

    private void validateReadMoving() {
        while (true) {
            try {
                bridgeGame.move(iv.readMoving());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean quit() {
        if (bridgeGame.isDiscord()) {
            retryTask(() -> {
                bridgeGame.retry(iv.readGameCommand());
            });
            if (!bridgeGame.isRetryGame()) {
                return true;
            }
            bridgeGame.backToFirstSection();
        }
        return false;
    }

    private void printResult() {
        ov.printResult(bridgeGame.getMap(), bridgeGame.getResultOfGame(), bridgeGame.getGameCount());
    }

    private static void retryTask(Task task) {
        while (true) {
            try {
                task.run();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    interface Task {
        void run();
    }
}
