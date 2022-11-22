package bridge.bridgeGame;

import bridge.bridge.BridgeMaker;
import bridge.bridge.BridgeNumberGenerator;

public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private BridgeGameState bridgeGameState;
    private Integer tryCount = 1;

    public BridgeGame(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    public BridgeGameState getBridgeGameState() {
        return bridgeGameState;
    }

    public Integer getTryCount() {
        return tryCount;
    }
}
