package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.Progress;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.constant.Constants.*;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
    }

    public void startGame() {
        OutputView.printGameMessage(GAME_START_MESSAGE + "\n");
        int size = inputView.readBridgeSize();
        bridgeGame.initBridge(size);
        moveControl();
    }

    private void moveControl() {
        String UorD = inputView.readMoving();
        Progress result = bridgeGame.move(UorD);
        printMap();
        if (result == Progress.FAILURE) {
            restartControl();
        } else if(result == Progress.PROGRESSION) {
            moveControl();
        } else if(result == Progress.SUCCESS) {
            ending(Progress.SUCCESS.getStateMessage());
        }
    }

    private void restartControl() {
        String RorQ = inputView.readGameCommand();
        if(RESTART_COMMAND.equals(RorQ)) {
            bridgeGame.retry();
            moveControl();
        } else if (QUIT_COMMAND.equals(RorQ)) {
            ending(Progress.FAILURE.getStateMessage());
        }
    }

    private void ending(String result) {
        OutputView.printGameMessage(FINAL_RESULT_MESSAGE);
        printMap();
        outputView.printResult(result, bridgeGame.getAttempt());
    }

    private void printMap() {
        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getUserAnswer());
    }

}
