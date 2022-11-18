package bridge.system.controller;

import bridge.system.service.BridgeGame;
import bridge.system.util.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {

    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeController(InputView inputView, OutputView outputView, BridgeGame bridgeGame, BridgeMaker bridgeMaker) {
        this.bridgeGame = bridgeGame;
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void playBridgeGame() {
        outputView.showGameStartMessage();
        List<String> randomBridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
    }
}
