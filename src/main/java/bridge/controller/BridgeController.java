package bridge.controller;

import bridge.domain.BridgeMaker;
import bridge.domain.generator.BridgeRandomNumberGenerator;

import java.util.List;

import static bridge.view.InputView.*;
import static bridge.view.OutputView.*;

public class BridgeController {
    private final BridgeMaker bridgeMaker;

    public BridgeController(BridgeRandomNumberGenerator bridgeRandomNumberGenerator) {
        this.bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    }

    public void start() {
        try {
            List<String> bridge = bridgeMaker.makeBridge(readBridgeSize().getBridgeSize());
        } catch (IllegalArgumentException error) {
            printErrorMessage(error.getMessage());
        }
    }
}
