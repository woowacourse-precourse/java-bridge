package bridge.domain.controller;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */

import bridge.constants.MovingDirection;
import bridge.constants.MovingPossibility;
import bridge.domain.model.Bridge;
import bridge.domain.model.CrossRecord;

/**
 * 필드(인스턴스 변수) 추가 가능
 * 패키지 변경 가능
 * 메소드 인자와 반환 타입은 필요에 따라 추가 혹은 변경 가능
 * 게임 진행에 필요한 메소드 추가 혹은 변경 가능
 *
 * 메소드 이름은 변경 불가능
 * InputView, OutputView 사용 불가능
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MovingPossibility move(int space, MovingDirection MOVE_TO) {
        MovingPossibility MOVING_POSSIBILITY = Bridge.checkMovingPossibility(space, MOVE_TO);

        CrossRecord.recordCrossedBridge(MOVE_TO, MOVING_POSSIBILITY);

        return MOVING_POSSIBILITY;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
