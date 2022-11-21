package bridge.game.context;

import bridge.domain.bridge.Bridge;
import bridge.game.BridgeGame;

public interface BridgeGameContext {
    void generateBridge(Bridge madeBridge);

    BridgeGame getBridgeGame();

    void plusRepeatCount();

    void writeHistory(final String resultMap);

    String getCachedHistory();

    Integer getRepeatCount();
}
