package bridge;

import bridge.domain.PlayResult;
import bridge.domain.Stage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<Stage> bridge;

    private final Map<Integer, PlayResult> roundResults;

    private int userMove;

    private int attempts;

    public BridgeGame(final List<Stage> bridge) {
        this.roundResults = new HashMap<>();
        this.bridge = bridge;
        this.userMove = 0;
        this.attempts = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return
     */
    public PlayResult move(final String direction) {
        PlayResult playResult = bridge.get(userMove).choose(direction);
        roundResults.put(userMove, playResult);
        userMove++;
        return playResult;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        userMove = 0;
        attempts += 1;
        roundResults.clear();
    }

    public boolean isClear() {
        return userMove == bridge.size() && isAllPass();
    }

    private boolean isAllPass() {
        return roundResults.values()
            .stream()
            .allMatch(PlayResult::isPass);
    }

    public boolean isOver() {
        return roundResults.values()
            .stream()
            .anyMatch(PlayResult::isFail);
    }

    public int getAttempts() {
        return attempts;
    }
}
