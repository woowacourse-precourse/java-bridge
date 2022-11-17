package bridge.controller;

import bridge.domain.vo.BridgeSize;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        BridgeSize bridgeSize = inputView.readBridgeSize();
    }
}
