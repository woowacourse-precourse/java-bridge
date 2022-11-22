package bridge.service;

import bridge.BridgeMaker;
import bridge.domain.*;

public class BridgeGameService {
    private static final int INIT_VALUE_OF_POSITION = 0;
    private static final int INIT_VALUE_OF_CHALLENGES = 1;

    private final BridgeMaker bridgeMaker;

    public BridgeGameService(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    public BridgeGame bridgeGame(BridgeSizeValidator bridgeSize) {
        Bridge bridge = new Bridge(
                bridgeMaker.makeBridge(bridgeSize.bridgeSize()));

        Player player = new Player(
                Position.of(INIT_VALUE_OF_POSITION),
                new ChallengeNumbers(INIT_VALUE_OF_CHALLENGES));

        return new BridgeGame(bridge, player);
    }
}
