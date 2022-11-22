package bridge.game.context;

import bridge.domain.bridge.BridgeSize;
import bridge.domain.code.BridgePosition;
import bridge.domain.code.GameStatus;
import bridge.domain.count.RepeatCount;

public interface BridgeGameContext {
    void generateBridge(BridgeSize bridgeSize);

    void writeHistory(final String resultMap);

    String getCachedHistory();

    RepeatCount getRepeatCount();

    void retry();

    void movePlayerUnit(BridgePosition movePosition);

    GameStatus gameStatus();
}
