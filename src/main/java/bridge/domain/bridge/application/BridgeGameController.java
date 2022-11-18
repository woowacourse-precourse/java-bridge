package bridge.domain.bridge.application;

import bridge.BridgeNumberGenerator;
import bridge.domain.bridge.model.Bridge;
import bridge.ui.input.InputView;
import bridge.ui.output.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void initGame() {
        outputView.printInitMessage();
    }

    public Bridge generateBaseBridge(BridgeNumberGenerator generator) {
        int bridgeSize = readBridgeSize();
        return Bridge.of(bridgeSize, generator);
    }

    private int readBridgeSize() {
        return inputView.readBridgeSize().toInteger();
    }
}
