package bridge.controller;

import bridge.model.*;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    BridgeGame bridgeGame;

    InputView iv;
    OutputView ov;
    boolean reEnter;

    public BridgeGameController() {
        this.bridgeGame = new BridgeGame();
        this.iv = new InputView();
        this.ov = new OutputView();
    }

    public void run() {
        makeBridge();
        playGame();
        printResult();
    }

    private void makeBridge() {
        reEnter = true;
        ov.gameStart();
        while(reEnter) {
            try {
                bridgeGame.makeBridge(iv.readBridgeSize());
                reEnter = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                reEnter = true;
            }
        }
    }

    private void playGame() {
        do {
            validateReadMoving();
            bridgeGame.makeMap(bridgeGame.getBridge(), bridgeGame.getMarks());
            ov.printMap(bridgeGame.getMap());
            if (quit()) {
                break;
            }
        } while (bridgeGame.isEndOfBridge());
    }

    private void validateReadMoving() {
        reEnter = true;
        while(reEnter) {
            try {
                bridgeGame.move(iv.readMoving());
                reEnter = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                reEnter = true;
            }
        }
    }

    private boolean quit() {
        if (bridgeGame.isDiscord()) {
            validateReadCommand();
            if (!bridgeGame.isRetryGame()) {
                return true;
            }
            bridgeGame.backToFirstSection();
        }
        return false;
    }

    private void validateReadCommand() {
        reEnter = true;
        while(reEnter) {
            try {
                bridgeGame.retry(iv.readGameCommand());
                reEnter = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                reEnter = true;
            }
        }
    }

    private void printResult() {
        ov.printResult(bridgeGame.getMap(), bridgeGame.getResultOfGame(), bridgeGame.getGameCount());
    }


}
