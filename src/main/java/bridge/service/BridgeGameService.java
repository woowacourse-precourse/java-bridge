package bridge.service;

import bridge.domain.bridgeGame.BridgeGame;
import bridge.domain.bridgeGame.gameStatus.gameStatics.GameResult;

import java.util.List;
import java.util.Queue;

public class BridgeGameService {
    private final static BridgeGameService bridgeGameService = new BridgeGameService();
    private BridgeGame bridgeGame;

    private BridgeGameService() {
    }

    public static BridgeGameService getInstance() {
        return bridgeGameService;
    }

    public void initBridgeGame(List<String> bridge) {
        bridgeGame = BridgeGame.initGame(bridge);
    }

    public GameResult move(String direction) {
        return bridgeGame.move(direction);
    }

    public void retryGame() {
        bridgeGame.retry();
    }

    public Queue<String> getGameStatics() {
        return bridgeGame.getGameStatics();
    }

}
