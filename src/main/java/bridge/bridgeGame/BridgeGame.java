package bridge.bridgeGame;

import bridge.bridge.BridgeMaker;
import bridge.bridge.BridgeNumberGenerator;
import bridge.bridge.BridgePosition;

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

    public void move(BridgePosition bridgePosition) {
        bridgeGameState.move(bridgePosition);
    }

    public void retry() {
        bridgeGameState.clearCurrent();
        tryCount++;
    }

    public void makeBridge(int bridgeSize) {
        bridgeGameState = new BridgeGameState(bridgeMaker.makeBridge(bridgeSize));
    }

    public boolean isWon() {
        return bridgeGameState.currentSize().equals(bridgeGameState.bridgeSize())
                && bridgeGameState.getMatched(bridgeGameState.currentSize() - 1);
    }
}
