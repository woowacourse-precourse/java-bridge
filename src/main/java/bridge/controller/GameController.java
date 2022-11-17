package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

import bridge.model.BridgeGame;
import bridge.model.userStages;

import bridge.standard.GameForm;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {
    private List<String> bridge;

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private final BridgeMaker bridgeMaker;

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    private final BridgeGame bridgeGame = new BridgeGame();


    public GameController() {
        outputView.guideStart();
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    }

    public void start() {
        setBridge();
        do {
            moveOneStep();
            if (wantEndWithFail()) {
                break;
            }
        } while (userStages.isNotReached(bridge.size()));
        exitGame();
    }

    private void setBridge() {
        outputView.guideInputBridgeSize();
        this.bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        outputView.emptyLine();
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
        outputView.printResult(
                userStages.getPositions(),
                userStages.getNumberOfAttempts(),
                userStages.getOutcome());
    }
}
