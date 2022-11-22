package bridge;

import java.util.List;

public class BridgeGameController {
    InputView  inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    BridgeGame bridgeGame;
    private int tryCount = 0;
    public void startService() {
        outputView.printGameStart();
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        gameProcess(bridge);
    }

}
