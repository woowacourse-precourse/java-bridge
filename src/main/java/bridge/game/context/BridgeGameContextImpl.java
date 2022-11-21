package bridge.game.context;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeSize;
import bridge.domain.bridge.maker.BridgeMaker;
import bridge.domain.bridge.maker.BridgeRandomNumberGenerator;
import bridge.domain.code.BridgePosition;
import bridge.domain.code.GameStatus;
import bridge.game.BridgeGame;

public class BridgeGameContextImpl implements BridgeGameContext {
    private BridgeGame bridgeGame;
    private Integer repeatCount = 1;
    private String cachedHistory;

    private void plusRepeatCount() {
        this.repeatCount += 1;
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
    public Integer getRepeatCount() {
        return this.repeatCount;
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
