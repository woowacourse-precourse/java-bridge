package bridge;

import bridge.Constant.OutputValue;

import java.util.List;

public class GameHelper {
    private final BridgeGame bridgeGame;
    private int trialCount = 1;

    public GameHelper(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void initGame(String upOrDown) {
        bridgeGame.move(upOrDown);
    }

    public void restart() {
        trialCount++;
        bridgeGame.retry();
    }

    public int getTrialCount() {
        return trialCount;
    }

    public boolean selectRightBlock() {
        return !bridgeGame.getResultBridge().contains(OutputValue.wrongBlock.get());
    }

    public boolean reachEnd() {
        return (bridgeGame.getBridgeSize() == bridgeGame.getResultBridgeSize()) && selectRightBlock();
    }

    public List<String> getResultBridge() {
        return bridgeGame.getResultBridge();
    }

    public List<String> getBridge() {
        return bridgeGame.getBridge();
    }
}