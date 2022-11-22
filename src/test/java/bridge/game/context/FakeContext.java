package bridge.game.context;

import bridge.domain.bridge.BridgeSize;
import bridge.domain.code.BridgePosition;
import bridge.domain.code.GameStatus;
import bridge.domain.count.RepeatCount;

public class FakeContext implements BridgeGameContext {
    private final GameStatus status;

    public FakeContext() {
        this.status = GameStatus.CLEAR;
    }

    public FakeContext(GameStatus status) {
        this.status = status;
    }


    @Override
    public void generateBridge(BridgeSize bridgeSize) {

    }

    @Override
    public void writeHistory(String resultMap) {

    }

    @Override
    public String getCachedHistory() {
        return "";
    }

    @Override
    public RepeatCount getRepeatCount() {
        return RepeatCount.initializeRepeatCount();
    }

    @Override
    public void retry() {

    }

    @Override
    public void movePlayerUnit(BridgePosition movePosition) {

    }

    @Override
    public GameStatus gameStatus() {
        return status;
    }
}
