package bridge.engine.state;

import bridge.engine.BridgeGame;
import bridge.engine.reporter.BridgeResult;
import bridge.engine.reporter.BridgeReporter;
import bridge.engine.GameCommand;

public class BridgeRetryState implements BridgeState {

    private BridgeGame bridgeGame;
    private BridgeReporter reporter;

    public BridgeRetryState(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
        this.reporter = new BridgeReporter();
    }

    @Override
    public void start(int size) {}

    @Override
    public boolean move(String direction) {
        return true;
    }

    @Override
    public boolean retry(String command) {
        boolean isRetry = GameCommand.valueOf(command).isRetry();

        if (isRetry) {
            bridgeGame.getUserDirection().clear();
            bridgeGame.setTryCount(bridgeGame.getTryCount() + 1);
            bridgeGame.setMoveCount(0);
            bridgeGame.setState(bridgeGame.getMoveState());
        }
        return isRetry;
    }

    @Override
    public BridgeResult end() {
        String result = reporter.reportBridge(bridgeGame.getBridge(), bridgeGame.getUserDirection());

        return new BridgeResult(result, "실패", bridgeGame.getTryCount());
    }
}
