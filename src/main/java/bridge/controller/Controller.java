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
        this.bridgeGame = new BridgeGame(readBridgeSize());
        System.out.println();
    }


    public void run() {
        this.gameState = this.bridgeGame.move(readMoving());
        OutputView.printMap();
        nonClearedState();
        clearedState();
    }
    private void nonClearedState() {
        while (this.gameState == GAME_ON_STATE.value || this.gameState == GAME_OVER_STATE.value) {
            if (this.gameState == GAME_ON_STATE.value) {
                nonClearedState_on();
            }
            if (this.gameState == GAME_OVER_STATE.value) {
                nonClearedState_over();
            }
        }
    }
    private void nonClearedState_on() {
        this.gameState = this.bridgeGame.move(readMoving());
        OutputView.printMap();
    }
    private void nonClearedState_over() {
        this.gameState = this.bridgeGame.retry(readGameCommand());
    }
    private void clearedState() {
        if (this.gameState == GAME_CLEAR_STATE.value) {
            OutputView.printResult();
        }
    }
}
