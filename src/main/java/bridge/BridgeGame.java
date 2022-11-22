package bridge;

import bridge.UI.output.MapDrawer;
import bridge.enums.Direction;
import bridge.enums.GameProgressState;
import bridge.enums.StageState;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private int stage;
    private StageState stageState;
    private GameProgressState progressState;
    private int tryCount;
    private final MapDrawer mapDrawer;

    public BridgeGame(Bridge bridge, MapDrawer mapDrawer) {
        this.bridge = bridge;
        this.stage = 0;
        this.stageState = null;
        this.progressState = GameProgressState.RUNNING;
        this.tryCount = 1;
        this.mapDrawer = mapDrawer;

    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Direction direction) {
        stage++;
        boolean isDirectionMatched = bridge.isDirectionMatched(stage, direction);
        updateStageState(isDirectionMatched);
        if (stageState.isPassed() && bridge.isLastStage(stage)) {
            progressState = GameProgressState.GAME_CLEAR;
        }
    }
    private void updateStageState(boolean isDirectionMatched) {
        if (isDirectionMatched) {
            stageState = StageState.PASS;
            return;
        }
        stageState = StageState.NON_PASS;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        stage = 0;
        tryCount++;
        progressState = GameProgressState.RUNNING;
        mapDrawer.initializeMap();
    }

    public void quit() {
        progressState = GameProgressState.STOP;
    }

    public boolean canMoving() {
        return stageState.isPassed() && !bridge.isLastStage(stage);
    }
    public boolean isCleared() {
        return progressState.isGameCleared();
    }
    public boolean isRunning() {
        return progressState.isRunning();
    }
    public int getTotalTryCount() {
        return tryCount;
    }
    public int getStage() {
        return stage;
    }
    public Bridge getBridge() {
        return bridge;
    }
    public boolean isCurrentStageDirectionMatched() {
        return stageState.isPassed();
    }


}
