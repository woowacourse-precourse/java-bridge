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
        try {
            makeBride();
            playGame();
            printResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void makeBride() {
        ov.gameStart();
        bridgeGame.makeBridge(iv.readBridgeSize());
    }

    private void playGame() {
        do {
            bridgeGame.move(iv.readMoving());
            bridgeGame.makeMap(bridgeGame.getBridge(), bridgeGame.getMarks());
            ov.printMap(bridgeGame.getMap());
            if (quit()) {
                break;
            }
        } while (bridgeGame.isEndOfBridge());
    }

    private boolean quit() {
        if (bridgeGame.isDiscord()) {
            if (!bridgeGame.retry(iv.readGameCommand())) {
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
