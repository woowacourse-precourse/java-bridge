package bridge.service;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameAnswer;
import bridge.domain.BridgeMaker;
import java.util.List;

public class BridgeGameService {
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public BridgeGameService(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    public void initBridgeGame(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        BridgeGameAnswer gameAnswer = new BridgeGameAnswer(bridge);
        this.bridgeGame = new BridgeGame(gameAnswer);
    }

    public boolean isRunning() {
        return bridgeGame.isRunning();
    }
}
