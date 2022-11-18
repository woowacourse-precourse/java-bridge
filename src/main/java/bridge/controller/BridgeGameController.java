package bridge.controller;

import bridge.model.BridgeGame;

import bridge.view.InputView;
import bridge.view.OutputView;

import bridge.standard.GameForm;

import java.util.List;

public class BridgeGameController {
    private final BridgeGame game = new BridgeGame();
    private final OutputView print = new OutputView();
    private final InputView input = new InputView();

    private List<String> bridge;

    public BridgeGameController() {
        print.guideStart();
        print.guideInputBridgeSize();
    }

    public int getBridgeSize() {
        return input.readBridgeSize();
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
        print.emptyLine();
    }

    public void start() {
        do {
            moveOneStage();
            if (isFailAndNotWantRetry()) {
                break;
            }
        } while (game.isInProgress(bridge.size()));
        exitGame();
    }


    private void moveOneStage() {
        print.guideInputMoving();
        game.move(input.readMoving(), bridge.get(game.nextIndex()));
        print.printMap(game.getCurrentPositions());
    }

    private boolean isFailAndNotWantRetry() {
        if (game.isFail()) {
            print.guideInputGameCommand();
            return !wantRetry(input.readGameCommand());
        }
        return false;
    }

    private boolean wantRetry(String gameCommand) {
        if (gameCommand.equals(GameForm.RESTART_CODE)) {
            game.retry();
            return true;
        }
        return false;
    }

    private void exitGame() {
        print.printResult(game.getCurrentPositions(),
                game.getNumberOfAttempts(),
                game.getOutcome());
    }
}
