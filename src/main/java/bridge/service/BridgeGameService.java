package bridge.service;

import bridge.domain.bridgegame.BridgeGame;
import bridge.dto.BridgeGameDto;
import bridge.repository.BridgeGameRepository;

public class BridgeGameService {
    private final static BridgeGameRepository bridgeGameRepository = BridgeGameRepository.getInstance();
    public void initBridgeGame(BridgeGameDto bridgeGameDto) {
        bridgeGameRepository.update(bridgeGameDto.toEntity());
    }

    public boolean isPassable(int distance, String movingDirection) {
        BridgeGame bridgeGame = bridgeGameRepository.get();
        String passableDirection = bridgeGame.getPassableDirectionAt(distance);

        return passableDirection.equals(movingDirection);
    }
}
