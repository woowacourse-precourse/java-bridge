package bridge.controller;

import bridge.game.BridgeGame;
import bridge.io.OutputView;

import static bridge.io.InputView.*;
import static bridge.io.MSG.INPUT_START;

public class Controller {

    /**
     * [Game state]
     * 0 - on game
     * 1 - game over
     * 2 - game clear
     * */
    private final BridgeGame bridgeGame;
    private int gameState;
    public Controller() {
        System.out.println(INPUT_START.message);
        System.out.println();
        bridgeGame = new BridgeGame(readBridgeSize());
        System.out.println();
    }

    public void run() {
        gameState = bridgeGame.move(readMoving());
        OutputView.printMap();
        nonClearedState();
        clearedState();
    }
    private void nonClearedState() {
        while (gameState == 0 || gameState==1) {
            if (gameState == 0) {
                gameState = bridgeGame.move(readMoving());
                OutputView.printMap();
            }
            if (gameState == 1) {
                gameState = bridgeGame.retry(readGameCommand());
            }
        }
    }
    private void clearedState() {
        if (gameState == 2) {
            OutputView.printResult();
        }
    }

}
