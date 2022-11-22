package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final MovingStatusSaver movingStatusSaver;
    private int retryCount;

    public BridgeGame(MovingStatusSaver movingStatusSaver, int retryCount) {
        this.movingStatusSaver = movingStatusSaver;
        this.retryCount = retryCount;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(final String moving) {
        movingStatusSaver.saveMovingStatus(moving);
    }

    public boolean isStopCondition(){
        return movingStatusSaver.isStopCondition();
    }

    public List<String> getSavedStatus(){
        return movingStatusSaver.getMovingStatus();
    }

    public boolean isFail(){
        return movingStatusSaver.isWrongBridge();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        movingStatusSaver.clearMovingStatus();
        addRetryCount();
    }

    private void addRetryCount(){
        this.retryCount++;
    }

    public int getRetryCount(){
        return this.retryCount;
    }
}
