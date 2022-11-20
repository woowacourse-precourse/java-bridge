package bridge.service;

import bridge.domain.bridgegame.BridgeGame;
import bridge.dto.BridgeGameDto;
import bridge.repository.BridgeGameRepository;

public class BridgeGameService {
    private final static BridgeGameRepository bridgeGameRepository = BridgeGameRepository.getInstance();

    public void initBridgeGame(BridgeGameDto bridgeGameDto) {
        bridgeGameRepository.update(bridgeGameDto.toEntity());
    }

    public void crossBridge(String movingDirection, boolean movingSuccess) {
        BridgeGame bridgeGame = bridgeGameRepository.get();
        BridgeGame movedBridgeGame = bridgeGame.move(movingDirection, movingSuccess);
        bridgeGameRepository.update(movedBridgeGame);
    }

    public String getGameMap() {
        BridgeGame bridgeGame = bridgeGameRepository.get();
        return bridgeGame.getGameMap();
    }

    public void retryGame() {
        BridgeGame bridgeGame = bridgeGameRepository.get();
        bridgeGameRepository.update(bridgeGame.retry());
    }
}
