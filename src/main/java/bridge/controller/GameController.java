package bridge.controller;

import bridge.model.BridgeGame;

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
            moveOneStage();
            if (isFailAndNotWantRetry()) {
                break;
            }
        } while (bridgeGame.inProgress(bridge.size()));
        exitGame();
    }


    private void moveOneStage() {
        outputView.guideInputMoving();
        bridgeGame.move(inputView.readMoving(), bridge.get(bridgeGame.nextIndex()));
        outputView.printMap(bridgeGame.getCurrentPositions());
    }

    private boolean isFailAndNotWantRetry() {
        if (bridgeGame.isFail()) {
            outputView.guideInputGameCommand();
            return !wantRetry(inputView.readGameCommand());
        }
        return false;
    }

    private boolean wantRetry(String gameCommand) {
        if (gameCommand.equals(GameForm.RESTART_VALUE)) {
            bridgeGame.retry();
            return true;
        }
        if (gameCommand.equals(GameForm.QUIT_VALUE)) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    private void exitGame() {
        outputView.printResult(bridgeGame.getCurrentPositions(),
                bridgeGame.getNumberOfAttempts(),
                bridgeGame.getOutcome());
    }
}
