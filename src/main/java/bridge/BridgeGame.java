package bridge;

// TODO 주의! InputView OutputView를 사용하지 않습니다.
//  `BridgeGame`의 메서드의 이름은 변경할 수 없습니다
//  인자와 반환 타입은 추가, 변경 가능합니다.

import bridge.domain.Bridge;
import bridge.domain.FootPrint;
import bridge.domain.FootrestLocation;
import bridge.domain.GameResultCode;
import bridge.domain.Result;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private Result result;

    public BridgeGame() {
        result = new Result();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param footrestLocation
     */
    public GameResultCode move(FootrestLocation footrestLocation) {
        Integer turnIdx = result.askTurn();
        if (bridge.canMove(turnIdx, footrestLocation)) {
            if (bridge.isLast(turnIdx)) {
                return result.recordSuccess(footrestLocation);
            }
            return result.recordMoving(footrestLocation);
        }
        return result.recordFail(footrestLocation);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        result.initResult();
    }

    public void saveBridge(Bridge bridge) {
        this.bridge = bridge;
    }

    public Result getResult() {
        return result;
    }

    public FootPrint getFootPrint() {
        return result.getFootPrint();
    }
}
