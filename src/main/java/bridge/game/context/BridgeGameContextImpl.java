package bridge.game.context;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeSize;
import bridge.domain.code.BridgePosition;
import bridge.domain.code.GameStatus;
import bridge.domain.count.RepeatCount;
import bridge.game.BridgeGame;

public class BridgeGameContextImpl implements BridgeGameContext {
    private BridgeGame bridgeGame;
    private RepeatCount repeatCount = RepeatCount.initializeRepeatCount();
    private String cachedHistory;

    private void plusRepeatCount() {
        repeatCount = repeatCount.increment(1);
    }

    @Override
    public void generateBridge(BridgeSize bridgeSize) {
        var bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridgeGame = new BridgeGame(new Bridge(bridgeMaker, bridgeSize));
    }

    @Override
    public void writeHistory(final String resultMap) {
        this.cachedHistory = resultMap;
    }

    @Override
    public String getCachedHistory() {
        return this.cachedHistory;
    }

    @Override
    public RepeatCount getRepeatCount() {
        return repeatCount;
    }

    @Override
    public void retry() {
        this.plusRepeatCount();
        this.bridgeGame.retry();
    }

    @Override
    public void movePlayerUnit(BridgePosition movePosition) {
        var history = bridgeGame.move(movePosition);
        this.writeHistory(history.resultByPositions());
    }

    @Override
    public GameStatus gameStatus() {
        return bridgeGame.getGameStatus();
    }
}
