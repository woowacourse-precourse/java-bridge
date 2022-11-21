package bridge.game.context;

import bridge.domain.bridge.Bridge;
import bridge.domain.code.BridgePosition;
import bridge.domain.code.GameStatus;

public class FakeContext implements BridgeGameContext {
    private GameStatus status;

    public FakeContext() {

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
        return null;
    }

    @Override
    public Integer getRepeatCount() {
        return null;
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
