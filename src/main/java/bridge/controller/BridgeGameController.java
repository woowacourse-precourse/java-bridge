package bridge.controller;

import bridge.standard.GameForm;
import bridge.model.BridgeGame;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {

    private final BridgeGame game = new BridgeGame();
    private final OutputView output = new OutputView();
    private final InputView input = new InputView();

    private List<String> bridge;

    public BridgeGameController() {
        output.guideStart();
        output.guideInputBridgeSize();
    }

    public int getBridgeSize() {
        return input.readBridgeSize();
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
        output.emptyLine();
    }

    public void start() {
        do {
            moveOneStage();
            if (game.isFail() && !wantRetry()) {
                break;
            }
        } while (!game.isSuccess());
        exitGame();
    }

    private void moveOneStage() {
        output.guideInputMoving();
        game.move(input.readMoving(), bridge.get(game.nextIndex()), bridge.size());
        output.printMap(game.getCurrentPositions());
    }

    private boolean wantRetry() {
        output.guideInputGameCommand();
        if (input.readGameCommand().equals(GameForm.RESTART_CODE)) {
            game.retry();
            return true;
        }
        return false;
    }

    private void exitGame() {
        output.printResult(game.getCurrentPositions(),
                game.getNumberOfAttempts(),
                game.getOutcome());
    }

}
