package bridge.data.dao;

import bridge.data.entity.BridgeGame;

public interface BridgeGameDao {

    BridgeGame insertBridgeGame(BridgeGame game);

    BridgeGame selectBridgeGame(String sessionId);
}
