package bridge.domain.gameManagement;

public enum BridgeState {
    DOWN_MOVABLE( 0, "D", "O ", " X"),
    UP_MOVABLE( 1, "U", " O", "X ");

    int movablePositionNumber;
    String movablePosition;
    String successfulBridgeState;
    String failedBridgeState;

    BridgeState(int movablePositionNumber, String movablePosition, String successfulBridgeState, String failedBridgeState) {
        this.movablePositionNumber = movablePositionNumber;
        this.movablePosition = movablePosition;
        this.successfulBridgeState = successfulBridgeState;
        this.failedBridgeState = failedBridgeState;
    }

    public int getMovablePositionNumber() {
        return movablePositionNumber;
    }

    public String getMovablePosition() {
        return movablePosition;
    }

    public String getSuccessfulBridgeState() {
        return successfulBridgeState;
    }

    public String getFailedBridgeState() {
        return failedBridgeState;
    }
}