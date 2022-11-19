package bridge.repository;

import bridge.domain.bridgegame.BridgeGame;

public class BridgeGameRepository {
    private static final BridgeGameRepository bridgeGameRepository = new BridgeGameRepository();

    private BridgeGame bridgeGame;

    private BridgeGameRepository() {
    }

    public static BridgeGameRepository getInstance() {
        return bridgeGameRepository;
    }

    public void update(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public BridgeGame get() {
        return bridgeGame;
    }
}
