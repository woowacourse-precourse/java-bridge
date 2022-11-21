package bridge.engine.state;

import bridge.engine.BridgeGame;
import bridge.engine.reporter.BridgeResult;
import bridge.engine.reporter.BridgeReporter;

import java.util.List;

public class BridgeMoveState implements BridgeState {

    private BridgeGame bridgeGame;
    private BridgeReporter reporter;

    public BridgeMoveState(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
        this.reporter = new BridgeReporter();
    }

    @Override
    public void start(int size) {
    }

    @Override
    public boolean move(String direction) {
        boolean isSuccess = true;
        bridgeGame.getUserDirection().add(direction);
        bridgeGame.setMoveCount(bridgeGame.getMoveCount() + 1);

        if (!isBridgeCorrect(bridgeGame.getBridge(), bridgeGame.getUserDirection())) {
            bridgeGame.setState(bridgeGame.getRetryState());
            isSuccess = false;
        }
        return isSuccess;
    }

    private boolean isBridgeCorrect(List<String> bridge, List<String> userDirection) {
        for (int i = 0; i < userDirection.size() && i < bridge.size(); ++i) {
            if (!(bridge.get(i).equals(userDirection.get(i)))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean retry(String command) {
        return false;
    }

    @Override
    public BridgeResult end() {
        String result = reporter.reportBridge(bridgeGame.getBridge(), bridgeGame.getUserDirection());

        return new BridgeResult(result, "성공", bridgeGame.getTryCount());
    }
}
