package bridge;

import java.util.List;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    InputView inputView;
    OutputView outputView;
    BridgeMaker bridgeMaker;

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void play() {
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);
    }
}
