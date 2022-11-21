package bridge;

import bridge.domain.result.PassingPositions;
import bridge.domain.userInfo.Position;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int attemptCount = 1;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Position position, PassingPositions passingPositions) {
        passingPositions.addPassingPositions(position);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(PassingPositions passingPositions) {
        passingPositions.resetPassingPosition();
        attemptCount++;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
