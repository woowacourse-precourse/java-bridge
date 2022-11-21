package bridge;

import java.util.List;


public class BridgeGameController {

    private final BridgeGame bridgeGame = new BridgeGame();
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void start() {
        outputView.printStart();
        int size = inputView.readBridgeSize();
        List<String> bridgeList = new BridgeMaker(bridgeNumberGenerator).makeBridge(size);
        MyBridge myBridge = new MyBridge(bridgeList, size);
        bridgeGame.move(myBridge);
    }

}
