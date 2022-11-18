package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.userStages;

import bridge.view.InputView;
import bridge.view.OutputView;

import bridge.standard.GameForm;

import java.util.List;

public class GameController {
    private final BridgeGame bridgeGame = new BridgeGame();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    private List<String> bridge;

    public GameController() {
        outputView.guideStart();
        outputView.guideInputBridgeSize();
    }

    public int getBridgeSize() {
        return inputView.readBridgeSize();
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
        outputView.emptyLine();
    }

    public void start() {
        do {
            moveOneStep();
            if (wantEndWithFail()) {
                break;
            }
        } while (userStages.isNotReached(bridge.size()));
        exitGame();
    }


    private void moveOneStep() {
        outputView.guideInputMoving();
        bridgeGame.move(inputView.readMoving(), bridge.get(userStages.nextIndex()));
        outputView.printMap(userStages.getPositions());
    }

    private boolean wantEndWithFail() {
        if (userStages.isNotCross()) {
            outputView.guideInputGameCommand();
            return isRetry(inputView.readGameCommand());
        }
        return false;
    }

    private boolean isRetry(String gameCommand) {
        if (gameCommand.equals(GameForm.RESTART_VALUE)) {
            bridgeGame.retry();
            return false;
        }
        if (gameCommand.equals(GameForm.QUIT_VALUE)) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    private void exitGame() {
        outputView.printResult(userStages.getPositions(), userStages.getNumberOfAttempts(), userStages.getOutcome());
    }
}
