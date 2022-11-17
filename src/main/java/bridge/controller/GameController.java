package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

import bridge.model.BridgeGame;
import bridge.model.userStage;

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
            if (!canMoveOneStep()) {
                break;
            }
        } while (bridgeGame.isNotReached(bridge.size()));
        exitGame();
    }

    private void setBridge() {
        outputView.guideInputBridgeSize();
        this.bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    private boolean canMoveOneStep() {
        outputView.guideInputMoving();
        bridgeGame.move(inputView.readMoving(), bridge.get(userStage.getSize()));
        outputView.printMap(userStage.getPositions());

        if (userStage.isNotCross()) {
            outputView.guideInputGameCommand();
            return isRetry(inputView.readGameCommand());
        }
        return true;
    }

    private boolean isRetry(String gameCommand) {
        if (gameCommand.equals("R")) {
            bridgeGame.retry();
            return true;
        }
        if (gameCommand.equals("Q")) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    private void exitGame() {
        outputView.printResult(
                userStage.getPositions(),
                userStage.getNumberOfAttempts(),
                userStage.getOutcome());
    }
}
