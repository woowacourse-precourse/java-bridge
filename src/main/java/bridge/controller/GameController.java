package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.CurrentBridge;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {
    private List<String> bridge;

    private BridgeNumberGenerator bridgeNumberGenerator;
    private BridgeMaker bridgeMaker;
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private BridgeGame bridgeGame = new BridgeGame();


    public GameController() {
        outputView.guideStart();
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    public void start() {
        outputView.guideInputBridgeSize();
        setBridge(inputView.readBridgeSize());
        do {
            if (!goOneStepMove()) {
                break;
            }
        } while (stillCrossing());
        exitGame();
    }

    private void setBridge(int size) {
        this.bridge = bridgeMaker.makeBridge(size);
    }

    private boolean goOneStepMove() {
        outputView.guideInputMoving();
        outputView.printMap(bridgeGame.move(inputView.readMoving(), bridge.get(CurrentBridge.getSize())));
        if (CurrentBridge.canNotCross()) {
            outputView.guideInputGameCommand();
            return askRetry(inputView.readGameCommand());
        }
        return true;
    }

    private boolean askRetry(String gameCommand) {
        if (gameCommand.equals("R")) {
            bridgeGame.retry();
            return true;
        }
        if (gameCommand.equals("Q")) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    private boolean stillCrossing() {
        if (CurrentBridge.getSize() == bridge.size()) {
            return false;
        }
        return true;
    }

    private void exitGame() {
        outputView.printResult(CurrentBridge.getCurrentMap(), CurrentBridge.getNumberOfAttempts(),CurrentBridge.getOutcome());
    }
}
