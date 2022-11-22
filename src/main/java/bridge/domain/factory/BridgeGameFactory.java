package bridge.domain.factory;

import bridge.domain.bridge.Bridge;
import bridge.domain.game.BridgeGame;
import bridge.domain.referee.Referee;

public class BridgeGameFactory {

    public BridgeGame createBridgeGame(int size) {
        return BridgeGame.from(createReferee(size));
    }

    private Referee createReferee(int size) {
        return Referee.from(createBridge(size));
    }

    private Bridge createBridge(int size) {
        BridgeFactory bridgeFactory = new BridgeFactory();
        return bridgeFactory.createBridge(size);
    }
}
