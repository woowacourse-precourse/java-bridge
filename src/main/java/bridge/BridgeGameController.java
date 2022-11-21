package bridge;

import java.util.List;

public class BridgeGameController {
    private final InputView inputView;
    private List<String> bridge;
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    public BridgeGameController() {
        inputView = new InputView();
    }

    public void run() {
        prepareBridgeGame();
    }

    private void prepareBridgeGame() {
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
    }



}
