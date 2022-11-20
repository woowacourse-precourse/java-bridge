package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.service.BridgeMakerService;

public class BridgeMakerController {
    private BridgeMakerService bridgeMakerService;
    private InputView inputView;
    private OutputView outputView;
    private int bridgeSize;

    public BridgeMakerController(BridgeMakerService bridgeMakerService, InputView inputView, OutputView outputView) {
        this.bridgeMakerService = bridgeMakerService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void makeBridge() {
        outputView.printStart();
        getBridgeSize();
        bridgeMakerService.setBridge(bridgeSize);
    }

    private void getBridgeSize() {
        while (true) {
            try {
                outputView.printBridgeSize();
                bridgeSize = inputView.readBridgeSize();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]");
            }
        }
    }
}
