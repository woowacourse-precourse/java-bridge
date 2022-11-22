package bridge;

import java.util.List;

public class BridgeGameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    BridgeGame bridgeGame;

    public void gameStart() {
        outputView.printStartMessage();
        initBridge();
    }

    private void initBridge() {
        Bridge bridge = new Bridge(makeBridge());
        bridgeGame = new BridgeGame(bridge);
    }

    private List<String> makeBridge() {
        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }
}
