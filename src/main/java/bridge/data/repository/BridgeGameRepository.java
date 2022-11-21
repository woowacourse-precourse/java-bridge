package bridge.data.repository;

import bridge.data.entity.BridgeGame;
import java.util.Optional;

public interface BridgeGameRepository {

    BridgeGame save(BridgeGame bridgeGame);

    Optional<BridgeGame> findById(String id);
}
