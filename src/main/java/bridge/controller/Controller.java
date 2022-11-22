package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputException;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Controller {
    private InputView input = new InputView();
    private OutputView output = new OutputView();
    private InputException inputException = new InputException();

    public List<String> bridgeMaker() {
        int size = inputException.checkLengthBridge(input.readBridgeSize());
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        return bridge;
    }
}
