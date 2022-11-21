package bridge.repository;

import bridge.domain.bridgeGame.BridgeGame;

import java.util.Queue;

public class BridgeGameRepository {
    private static final BridgeGameRepository bridgeGameRepository = new BridgeGameRepository();

    private BridgeGame bridgeGame;

    private BridgeGameRepository() {
    }

    public static BridgeGameRepository getInstance() {
        return bridgeGameRepository;
    }

    public void save(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public boolean getCrossSuccess() {
        return bridgeGame.crossSuccess();
    }

    public void crossOneBlock(String direction, boolean crossSuccess) {
        bridgeGame.move(direction, crossSuccess);
    }

    public void retry() {
        bridgeGame.retry();
    }

    public String getBridgeMap() {
        return bridgeGame.bridgeMap();
    }

    public Queue<String> getGameStatics() {
        return bridgeGame.gameStatics();
    }
}
