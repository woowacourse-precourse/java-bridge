package bridge;

import java.util.List;

public class BridgeGameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void gameStart() {
        outputView.printStartMessage();
        Bridge bridge = new Bridge(makeBridge());
    }

    private List<String> makeBridge() {
        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }
}
