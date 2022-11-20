package bridge.game.context;

import bridge.domain.bridge.Bridge;
import bridge.game.BridgeGame;

public class BridgeGameContext {
    private BridgeGame bridgeGame;
    private Integer repeatCount = 0;
    private String cachedHistory;

    public void generateBridge(Bridge madeBridge) {
        this.bridgeGame = new BridgeGame(madeBridge);
    }

    public BridgeGame getBridgeGame() {
        return bridgeGame;
    }

    public void plusRepeatCount() {
        this.repeatCount += 1;
    }

    public void writeHistory(final String resultMap) {
        this.cachedHistory = resultMap;
    }

    public String getCachedHistory() {
        return this.cachedHistory;
    }

    public Integer getRepeatCount() {
        return this.repeatCount;
    }
}
