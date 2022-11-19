package bridge.controller;

import bridge.InputView;
import bridge.OutputView;
import bridge.service.BridgeMakerService;

public class BridgeMakerController {
    private BridgeMakerService bridgeMakerService;
    private InputView inputView;
    private OutputView outputView;

    public BridgeMakerController(BridgeMakerService bridgeMakerService, InputView inputView, OutputView outputView) {
        this.bridgeMakerService = bridgeMakerService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void makeBridge() {
        outputView.printStart();
        outputView.printBridgeSize();

        int bridgeSize = inputView.readBridgeSize();
        bridgeMakerService.setBridge(bridgeSize);
    }
}
