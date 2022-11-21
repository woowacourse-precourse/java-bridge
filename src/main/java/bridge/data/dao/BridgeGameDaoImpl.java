package bridge.data.dao;

import bridge.data.entity.BridgeGame;
import bridge.data.repository.BridgeGameRepository;
import bridge.data.repository.BridgeGameRepositoryImpl;
import java.util.Optional;

public class BridgeGameDaoImpl implements BridgeGameDao {

    private static final String GAME_NOT_FOUND = "해당하는 ID를 가진 게임이 존재하지 않습니다.";

    private final BridgeGameRepository bridgeGameRepository;

    public BridgeGameDaoImpl() {
        bridgeGameRepository = BridgeGameRepositoryImpl.getInstance();
    }

    @Override
    public BridgeGame insertBridgeGame(BridgeGame bridgeGame) {
        return bridgeGameRepository.save(bridgeGame);
    }

    @Override
    public BridgeGame selectBridgeGame(String sessionId) {
        Optional<BridgeGame> selectedBridgeGame = bridgeGameRepository.findById(sessionId);
        if (selectedBridgeGame.isEmpty()) {
            throw new IllegalStateException(GAME_NOT_FOUND);
        }
        return selectedBridgeGame.get();
    }
}
