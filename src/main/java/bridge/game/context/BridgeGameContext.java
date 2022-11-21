package bridge.game.context;

import bridge.domain.bridge.Bridge;
import bridge.domain.code.BridgePosition;
import bridge.domain.code.GameStatus;
import bridge.game.BridgeGame;

public interface BridgeGameContext {
    void generateBridge(Bridge madeBridge);

    BridgeGame getBridgeGame();

    void writeHistory(final String resultMap);

    String getCachedHistory();

    Integer getRepeatCount();

    void retry();

    void movePlayerUnit(BridgePosition movePosition);

    GameStatus gameStatus();
}
