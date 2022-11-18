package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printStartGame();
        BridgeGame bridgeGame = makeBridgeGame(new BridgeRandomNumberGenerator());
    }

    public BridgeGame makeBridgeGame(BridgeNumberGenerator numberGenerator) {
        int bridgeSize;
        try {
            bridgeSize = inputView.readBridgeSize();
            return new BridgeGame(new BridgeMaker(numberGenerator));
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return makeBridgeGame(numberGenerator);
        }
    }
}
