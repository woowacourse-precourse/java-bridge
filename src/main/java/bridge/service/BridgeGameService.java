package bridge.service;

import bridge.domain.bridge_game.Bridge;
import bridge.domain.bridge_game.BridgeGame;
import bridge.domain.bridge_game.NumberOfChallenges;
import bridge.domain.bridge_game.Player;
import bridge.domain.bridge_game.Position;
import bridge.BridgeMaker;
import bridge.domain.validation.BridgeSize;

public class BridgeGameService {

    private static final int INIT_VALUE_OF_POSITION = 0;
    private static final int INIT_VALUE_OF_CHALLENGES = 1;

    private final BridgeMaker bridgeMaker;

    public BridgeGameService(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    public BridgeGame bridgeGame(final BridgeSize bridgeSize) {
        Bridge bridge = new Bridge(
                bridgeMaker.makeBridge(bridgeSize.bridgeSize()));

        Player player = new Player(
                Position.of(INIT_VALUE_OF_POSITION),
                new NumberOfChallenges(INIT_VALUE_OF_CHALLENGES));

        return new BridgeGame(bridge, player);
    }
}