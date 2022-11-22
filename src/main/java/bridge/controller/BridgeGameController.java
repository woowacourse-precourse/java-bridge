package bridge.controller;

import bridge.BridgeMaker;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private List<String> correctBridge;

    public BridgeGameController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void run() {
        try {
            startBrideGame();
            System.out.println(correctBridge);
        } catch (IllegalArgumentException illegalArgumentException) {

        }
    }

    private void startBrideGame() {
        outputView.printStartMessage();
        correctBridge = makeBridge();
    }

    private List<String> makeBridge() {
        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }
}
