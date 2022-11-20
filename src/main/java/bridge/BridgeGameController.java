package bridge;

import java.util.List;

public class BridgeGameController {

    private final BridgeGame bridgeGame = new BridgeGame();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

    public void start() {
        outputView.printStart();
        int size = inputView.readBridgeSize();
        List<String> bridgeList = new BridgeMaker(bridgeNumberGenerator).makeBridge(size);
    }
}
