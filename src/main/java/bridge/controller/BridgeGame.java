package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeRecord;
import bridge.domain.Command;
import bridge.domain.Result;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Result move(int indexOfBridge, Command direction) {
        if (!Bridge.canMove(indexOfBridge, direction)) {
            return Result.FAIL;
        }
        if (indexOfBridge == Bridge.getBridgeSize() - 1) {
            return Result.ARRIVED;
        }
        return Result.SUCCESS;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeRecord retry() {
        return new BridgeRecord();
    }
}
