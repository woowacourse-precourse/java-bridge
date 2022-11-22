package bridge.model;

import bridge.model.constant.BridgePattern;
import bridge.model.constant.GameCondition;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final int DEFAULT_VALUE = 0;
    private final int GAME_COUNT_INIT = 1;
    private final List<String> bridge;
    private final Progress progress;
    private int pointer = DEFAULT_VALUE;
    private int counter = GAME_COUNT_INIT;

    public BridgeGame(List<String> bridge, Progress progress) {
        this.bridge = bridge;
        this.progress = progress;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameCondition move(BridgePattern bridgePattern) {
        GameCondition gameCondition = inspectCondition(bridgePattern);
        progress.updateProgress(bridgePattern, gameCondition.getSymbol());

        return isGoalSuccess(gameCondition);
    }

    private GameCondition inspectCondition(BridgePattern bridgePattern) {
        String move = bridge.get(pointer++);

        return isConditionProgress(bridgePattern, move);
    }

    private GameCondition isConditionProgress(BridgePattern bridgePattern, String move) {
        if (bridgePattern.isInputEqual(move)) {
            return GameCondition.IN_PROGRESS;
        }
        return GameCondition.FAILURE;
    }

    private GameCondition isGoalSuccess(GameCondition gameCondition) {
        return isConditionGoal(gameCondition);
    }

    private GameCondition isConditionGoal(GameCondition gameCondition) {
        if (pointer == bridge.size() && gameCondition == GameCondition.IN_PROGRESS) {
            return GameCondition.GOAL;
        }

        return gameCondition;
    }

    public Progress exportProgress() {
        return progress;
    }

    public int exportGameCount() {
        return counter;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        counter++;
        pointer = DEFAULT_VALUE;
        progress.clearProgress();
    }
}
