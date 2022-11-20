package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playGreeting() {
        outputView.printGreeting();
    }

    public void setupGame() {

    }

    public void getNowGameCondition() {

    }

    public void moveOneStep() {

    }

    public void figureOutToRestartGame() {

    }

    public void showResult() {

    }
}
