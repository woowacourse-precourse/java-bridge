package bridge.service;

import bridge.dto.BridgeGameDto;
import bridge.repository.BridgeGameRepository;

public class BridgeGameService {
    private final static BridgeGameRepository bridgeGameRepository = BridgeGameRepository.getInstance();
    public void initBridgeGame(BridgeGameDto bridgeGameDto) {
        bridgeGameRepository.update(bridgeGameDto.toEntity());
    }
}
