package bridge.domain.bridge.application;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.domain.bridge.model.BridgeMap;
import bridge.ui.input.InputView;
import bridge.ui.output.OutputView;
import java.util.List;

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

    public BridgeMap generateBaseBridge(BridgeNumberGenerator generator) {
        int bridgeSize = readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        return BridgeMap.from(bridge);
    }

    private int readBridgeSize() {
        return inputView.readBridgeSize().toInteger();
    }
}
