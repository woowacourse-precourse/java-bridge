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
        currentMovementRecord.addMovementRecord(spotInfo);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount += 1;
        clearLastMovementRecord();
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean isSafeSpot(int position, BridgeLane bridgeLane) {
        return bridge.isSafeSpot(position, bridgeLane);
    }

    public BridgeLane getCurrentMovementRecord(int index) {
        return currentMovementRecord.getMovementRecord(index);
    }

    public int getCurrentPosition() {
        return currentMovementRecord.getMovementCount();
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

    private void clearLastMovementRecord() {
        currentMovementRecord.clearMovementRecord();
    }

    private boolean doesPassUnsafeSpot(int position) {
        BridgeLane laneOnPosition = getCurrentMovementRecord(position);
        return !bridge.isSafeSpot(position, laneOnPosition);
    }
}
