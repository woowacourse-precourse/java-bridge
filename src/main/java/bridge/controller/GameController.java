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
            oneStepMove();
        } while (stillCrossing());
        outputView.printResult(CurrentBridge.getCurrentMap(), CurrentBridge.getNumberOfAttempts(),CurrentBridge.getOutcome());
    }

    private void setBridge(int size) {
        this.bridge = bridgeMaker.makeBridge(size);
    }

    private void oneStepMove() {
        outputView.guideInputMoving();
        outputView.printMap(bridgeGame.move(inputView.readMoving(), bridge.get(CurrentBridge.getSize())));
        if (CurrentBridge.canNotCross()) {
            outputView.guideInputGameCommand();
            askRetry(inputView.readGameCommand());
        }
    }

    private void askRetry(String gameCommand) {
        if (gameCommand.equals("R")) {
            bridgeGame.retry();
        }
        if (gameCommand.equals("Q")) {
            outputView.printResult(CurrentBridge.getCurrentMap(), CurrentBridge.getNumberOfAttempts(),CurrentBridge.getOutcome());
        }

    }

    private boolean stillCrossing() {
        if (CurrentBridge.getSize() == bridge.size()) {
            return false;
        }
        return true;
    }
}
