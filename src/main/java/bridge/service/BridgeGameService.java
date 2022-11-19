package bridge.service;

import bridge.dto.BridgeGameDto;
import bridge.repository.BridgeGameRepository;
import bridge.repository.BridgeRepository;

public class BridgeGameService {
    private final static BridgeGameRepository bridgeGameRepository = BridgeGameRepository.getInstance();
    private final static BridgeRepository bridgeRepository = BridgeRepository.getInstance();
    public void initBridgeGame(BridgeGameDto bridgeGameDto) {
        bridgeGameRepository.update(bridgeGameDto.toEntity());
    }

    public boolean isPassable(int distance, String movingDirection) {
        String passableDirection = bridgeRepository.getPassableDirectionAt(distance);
        return movingDirection.equals(passableDirection);
    }
}
