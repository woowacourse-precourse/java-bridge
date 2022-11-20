package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
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

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(BridgeLane spotInfo) {
        currentMovementRecord.addMovement(spotInfo);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
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
