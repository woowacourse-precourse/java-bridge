package bridge.controller;

import bridge.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private List<String> resultBridge;

    public BridgeGameController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void run() {
        try {
            start();
        } catch (IllegalArgumentException illegalArgumentException) {

        }
    }

    private void start() {
        outputView.printStartMessage();
        resultBridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
    }
}
