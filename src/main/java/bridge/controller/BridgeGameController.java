package bridge.controller;

import bridge.model.*;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.controller.Task.retryTask;

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

}
