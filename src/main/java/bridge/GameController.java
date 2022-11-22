package bridge;

import java.util.List;

public class GameController {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    private int bridgeSize;
    private List<String> bridge;

    public void start() {
        outputView.printStart();
        outputView.printBridgeSize();
        bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }
}
