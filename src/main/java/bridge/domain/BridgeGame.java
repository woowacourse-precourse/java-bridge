package bridge.domain;

import bridge.domain.constant.ResultMessage;

public class BridgeGame {
    private final NumberOfTry numberOfTry = new NumberOfTry();
    private Bridge bridge;
    private BridgeGameResult bridgeGameResult;
    private int currentPosition;

    public BridgeGame(Bridge bridge) {
        makeBridgeGame(bridge);
    }

    private void makeBridgeGame(Bridge bridge) {
        this.bridge = bridge;
        bridgeGameResult = new BridgeGameResult();
        currentPosition = -1;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public BridgeGameResult getBridgeGameResult() {
        return bridgeGameResult;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public int getNumberOfTry() {
        return numberOfTry.getCount();
    }

    public void move(String direction) {
        increaseCurrentPosition();
        bridgeGameResult.makeMoveResult(bridge, currentPosition, direction);
    }

    private void increaseCurrentPosition() {
        currentPosition++;
    }

    public void retry(Bridge bridge) {
        numberOfTry.increaseCount();
        makeBridgeGame(bridge);
    }

    public String getSuccessOrFailure() {
        if (currentPosition == bridge.getSize() - 1) {
            return ResultMessage.SUCCESS.toString();
        }
        return ResultMessage.FAILURE.toString();
    }
}
