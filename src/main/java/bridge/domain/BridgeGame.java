package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;

    private int round;

    private int attempts;

    public BridgeGame(final List<String> stages) {
        this.bridge = new Bridge(stages);
        this.attempts = 1;
        this.round = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameResult move(final Direction direction) {
        CompareResult compareResult = bridge.cross(round++, direction);
        return new GameResult(direction, compareResult);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        attempts += 1;
        round = 0;
    }

    public int getAttempts() {
        return attempts;
    }

    public boolean isFinished() {
        return round == bridge.getNumberOfStage();
    }
}
