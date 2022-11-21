package bridge.service;

import bridge.domain.bridgeGame.BridgeGame;
import bridge.repository.BridgeGameRepository;

import java.util.Queue;

public class BridgeGameService {
    private final static BridgeGameRepository bridgeGameRepository = BridgeGameRepository.getInstance();

    public void initBridgeGame() {
        bridgeGameRepository.save(BridgeGame.initGame());
    }

    public boolean getCrosseSuccess() {
        return bridgeGameRepository.getCrossSuccess();
    }

    public void crossOneBlock(String direction, boolean crossSuccess) {
        bridgeGameRepository.crossOneBlock(direction, crossSuccess);
    }

    public void retryGame() {
        bridgeGameRepository.retry();
    }

    public String getBridgeMap() {
        return bridgeGameRepository.getBridgeMap();
    }

    public Queue<String> getGameStatics() {
        return bridgeGameRepository.getGameStatics();
    }
}
