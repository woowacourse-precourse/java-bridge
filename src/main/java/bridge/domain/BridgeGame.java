package bridge.domain;

import java.util.List;

public class BridgeGame {
    public enum Status {
        TBD, SUCCESS, FAIL
    }

    private final Bridge bridge;
    private final MovementRecord currentMovementRecord;
    private int tryCount;

    public BridgeGame(List<String> safeLaneInfo) {
        this.bridge = new Bridge(safeLaneInfo);
        this.currentMovementRecord = new MovementRecord();
        tryCount = 1;
    }

    public void move(BridgeLane spotInfo) {
        currentMovementRecord.addMovement(spotInfo);
    }

    public void retry() {
        tryCount += 1;
        currentMovementRecord.clearMovementRecord();
    }

    public boolean isSafeSpot(int position, BridgeLane bridgeLane) {
        return bridge.isSafeSpot(position, bridgeLane);
    }

    public BridgeLane getCurrentMovementAtPosition(int position) {
        return currentMovementRecord.getMovementAtPosition(position);
    }

    public int getCurrentPosition() {
        return currentMovementRecord.getMovementCount();
    }

    public int getTryCount() {
        return tryCount;
    }

    public Status getStatus() {
        for(int i = 1; i <= currentMovementRecord.getMovementCount(); i++) {
            if(doesPassUnsafeSpot(i)) {
                return Status.FAIL;
            }
        }
        if(currentMovementRecord.getMovementCount() == bridge.getBridgeSize()) {
            return Status.SUCCESS;
        }
        return Status.TBD;
    }

    private boolean doesPassUnsafeSpot(int position) {
        BridgeLane laneAtPosition = getCurrentMovementAtPosition(position);
        return !bridge.isSafeSpot(position, laneAtPosition);
    }
}
