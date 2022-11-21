package bridge;

import java.util.List;

public class BridgeController {

    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private List<String> bridge;
    public void run() {
        int bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        for (int i = 0; i < bridgeSize; i++) {
            String direction = inputView.readMoving();
            if (!bridgeGame.move(direction)) {
                break;
            }
        }
    }
}