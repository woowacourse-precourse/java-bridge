package bridge;

import bridge.domain.Bridge;
import bridge.domain.Direction;
import bridge.domain.GameResult;
import bridge.domain.CompareResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;

    private final Map<Integer, CompareResult> roundResults;

    private int attempts;

    public BridgeGame(final List<String> stages) {
        this.roundResults = new HashMap<>();
        this.bridge = new Bridge(stages);
        this.attempts = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameResult move(final int round, final Direction direction) {
        CompareResult compareResult = bridge.cross(round, direction);
        roundResults.put(round, compareResult);
        return new GameResult(direction, compareResult);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        attempts += 1;
        roundResults.clear();
    }

    public boolean isClear() {
        return roundResults.size() != 0 && isAllPass();
    }

    private boolean isAllPass() {
        return roundResults.values()
            .stream()
            .allMatch(CompareResult::isPass);
    }

    public boolean isOver() {
        return roundResults.size() != 0 && containsFail();
    }

    private boolean containsFail() {
        return roundResults.values()
            .stream()
            .anyMatch(CompareResult::isFail);
    }

    public int getAttempts() {
        return attempts;
    }

    public int getStages() {
        return bridge.getStages();
    }
}
