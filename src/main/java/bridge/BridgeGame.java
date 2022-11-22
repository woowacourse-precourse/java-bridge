package bridge;

import utils.ConstValue;

public class BridgeGame {

    private final Bridge bridge;

    private int tryCount;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.tryCount = 1;
    }

    public boolean move(String movingPlace) {
        bridge.addUpBridgeResult(movingPlace);
        bridge.addDownBridgeResult(movingPlace);

        return bridge.isCorrect(movingPlace);
    }

    private void retry() {
        bridge.initBridge();
        tryCount++;
    }

    public int getTryCount() {
        return tryCount;
    }

    public String getGameResult() {
        if (bridge.isCompleted()) {
            return ConstValue.SUCCESS;
        }
        return ConstValue.FAIL;
    }

    public boolean gameContinue(Bridge bridge, boolean isQuit) {
        return !bridge.isCompleted() && !isQuit;
    }

    public boolean isRetry(String gameCommand, boolean isCorrect) {
        if (gameCommand.equals(ConstValue.RETRY)) {
            retry();
        }

        return gameCommand.equals(ConstValue.RETRY) && !isCorrect;
    }

    public boolean isQuit(String gameCommand) {
        return gameCommand.equals(ConstValue.QUIT);
    }
}
