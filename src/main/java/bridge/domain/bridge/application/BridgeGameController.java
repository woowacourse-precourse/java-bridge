package bridge.domain.bridge.application;

import bridge.ui.input.InputView;
import bridge.ui.input.dto.BridgeSize;
import bridge.ui.output.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void init() {
        outputView.printInitMessage();
        BridgeSize bridgeSize = inputView.readBridgeSize();
    }
}
