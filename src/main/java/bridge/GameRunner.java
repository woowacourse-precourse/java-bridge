package bridge;

import java.util.List;

public class GameRunner {
    private List<String> bridge;
    private BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public GameRunner() {
        this.bridgeGame = new BridgeGame();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        initializeBridge();
    }

    private void initializeBridge(){
        this.bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
    }
}
