package bridge.data.repository;

import bridge.data.entity.BridgeGame;
import java.util.HashMap;
import java.util.Optional;

public class BridgeGameRepositoryImpl implements BridgeGameRepository {

    private BridgeGameRepositoryImpl() {}

    private static class SingletonHelper {
        private static final BridgeGameRepositoryImpl INSTANCE = new BridgeGameRepositoryImpl();
    }

    public static BridgeGameRepositoryImpl getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private final HashMap<String, BridgeGame> bridgeGameRepository = new HashMap<>();

    @Override
    public BridgeGame save(BridgeGame bridgeGame) {
        bridgeGameRepository.put(bridgeGame.getSessionId(), bridgeGame);
        return bridgeGame;
    }

    @Override
    public Optional<BridgeGame> findById(String id) {
        return Optional.ofNullable(bridgeGameRepository.get(id));
    }
}
