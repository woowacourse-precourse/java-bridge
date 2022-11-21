package bridge.game.context;

import bridge.domain.bridge.Bridge;
import bridge.domain.code.BridgePosition;
import bridge.domain.code.GameStatus;

public interface BridgeGameContext {
    void generateBridge(Bridge madeBridge);

    void writeHistory(final String resultMap);

    String getCachedHistory();

    Integer getRepeatCount();

    void retry();

    void movePlayerUnit(BridgePosition movePosition);

    GameStatus gameStatus();
}
