package bridge.game.context;

import bridge.domain.bridge.Bridge;
import bridge.domain.code.BridgePosition;
import bridge.domain.code.GameStatus;

public class FakeContext implements BridgeGameContext {
    private final GameStatus status;

    public FakeContext() {
        this.status = GameStatus.CLEAR;
    }

    public FakeContext(GameStatus status) {
        this.status = status;
    }

    @Override
    public void generateBridge(Bridge madeBridge) {

    }

    @Override
    public void writeHistory(String resultMap) {

    }

    @Override
    public String getCachedHistory() {
        return "";
    }

    @Override
    public Integer getRepeatCount() {
        return 0;
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
