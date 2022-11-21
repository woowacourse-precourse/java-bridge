package bridge.game.context;

import bridge.domain.bridge.Bridge;
import bridge.game.BridgeGame;

public class BridgeGameContextImpl implements BridgeGameContext {
    private BridgeGame bridgeGame;
    private Integer repeatCount = 0;
    private String cachedHistory;


    @Override
    public void generateBridge(Bridge madeBridge) {
        this.bridgeGame = new BridgeGame(madeBridge);
    }

    @Override
    public BridgeGame getBridgeGame() {
        return bridgeGame;
    }

    @Override
    public void plusRepeatCount() {
        this.repeatCount += 1;
    }

    @Override
    public void writeHistory(final String resultMap) {
        this.cachedHistory = resultMap;
    }

    @Override
    public String getCachedHistory() {
        return this.cachedHistory;
    }

    @Override
    public Integer getRepeatCount() {
        return this.repeatCount;
    }
}
