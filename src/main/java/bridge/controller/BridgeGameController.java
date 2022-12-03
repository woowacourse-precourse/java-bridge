package bridge.controller;

import bridge.model.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void run() {
        outputView.printStart();
        List<String> bridge = generateBridgePhase();
        bridgeGame = new BridgeGame(bridge);
        runSet();
        outputView.printResult(bridgeGame.getResult());

    }

    private List<String> generateBridgePhase() {
        while (true) {
            outputView.printBridgeSize();
            try {
                int bridgeSize = inputView.readBridgeSize();
                return bridgeMaker.makeBridge(bridgeSize);
            } catch (IllegalArgumentException | IllegalStateException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private void runSet() {
        while (!bridgeGame.isSuccess()) {
            boolean isSafe = runRound();
            boolean isAgain = true;
            if (!isSafe) {
                isAgain = retryPhase();
            }
            if (!isAgain) {
                break;
            }
        }
    }

    private boolean runRound() {
        boolean isSafe = movePhase();
        outputView.printMap(bridgeGame.getSteps());
        return isSafe;
    }

    private boolean movePhase() {
        while (true) {
            outputView.printMoving();
            try {
                String direction = inputView.readMoving();
                return bridgeGame.move(direction);
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    private boolean retryPhase() {
        while (true) {
            outputView.printRetry();
            try {
                String gameCommand = inputView.readGameCommand();
                return bridgeGame.retry(gameCommand);
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }
}
