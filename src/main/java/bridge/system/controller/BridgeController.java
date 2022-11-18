package bridge.system.controller;

import bridge.system.service.BridgeGame;
import bridge.system.util.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playBridgeGame() {
        outputView.showGameStartMessage();
        bridgeGame.makeBridge(inputView.readBridgeSize());
    }
}
