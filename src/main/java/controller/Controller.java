package controller;

import bridge.BridgeGame;
import view.InputView;
import view.OutputView;

public class
Controller {

    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(BridgeGame bridgeGame, InputView inputView, OutputView outputView) {
        this.bridgeGame = bridgeGame;
        this.inputView = inputView;
        this.outputView = outputView;
    }
}
