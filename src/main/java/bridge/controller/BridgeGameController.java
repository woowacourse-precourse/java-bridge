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
        makeBridge();
        playGame();
        printResult();
    }

    private void makeBridge() {
        ov.gameStart();
        while(true) {
            try {
                bridgeGame.makeBridge(iv.readBridgeSize());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
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
        while(true) {
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
            validateReadCommand();
            if (!bridgeGame.isRetryGame()) {
                return true;
            }
            bridgeGame.backToFirstSection();
        }
        return false;
    }

    private void validateReadCommand() {
        while(true) {
            try {
                bridgeGame.retry(iv.readGameCommand());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printResult() {
        ov.printResult(bridgeGame.getMap(), bridgeGame.getResultOfGame(), bridgeGame.getGameCount());
    }


}
