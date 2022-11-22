package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.Direction;
import bridge.domain.GameResult;
import java.util.ArrayList;
import java.util.List;

public class BridgeGameService {

    private final List<GameResult> results;

    private final BridgeGame game;

    public BridgeGameService(final int bridgeSize) {
        this.game = new BridgeGame(buildBridge(bridgeSize));
        this.results = new ArrayList<>();
    }

    private List<String> buildBridge(final int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public boolean isClear() {
        return game.isFinished() && isAllPass();
    }

    private boolean isAllPass() {
        return results.stream()
            .allMatch(GameResult::isPass);
    }

    public GameResult move(final Direction direction) {
        GameResult gameResult = game.move(direction);
        results.add(gameResult);
        return gameResult;
    }

    public boolean isOver() {
        return results.size() != 0
            && results.stream().anyMatch(GameResult::isFail);
    }

    public int getAttempts() {
        return game.getAttempts();
    }

    public void retry() {
        results.clear();
        game.retry();
    }
}
