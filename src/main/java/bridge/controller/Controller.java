package bridge.controller;

import bridge.game.BridgeGame;
import bridge.io.OutputView;

import static bridge.game.GameState.*;
import static bridge.io.InputView.*;
import static bridge.io.IO_msg.INPUT_START;

public class Controller {

    private final BridgeGame bridgeGame;
    private int gameState;
    public Controller() {
        System.out.println(INPUT_START.msg);
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
        while (gameState == GAME_ON_STATE.value || gameState == GAME_OVER_STATE.value) {
            if (gameState == GAME_ON_STATE.value) {
                gameState = bridgeGame.move(readMoving());
                OutputView.printMap();
            }
            if (gameState == GAME_OVER_STATE.value) {
                gameState = bridgeGame.retry(readGameCommand());
            }
        }
    }
    private void clearedState() {
        if (gameState == GAME_CLEAR_STATE.value) {
            OutputView.printResult();
        }
    }
}
