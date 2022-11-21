package bridge.model;

import static bridge.ExceptionConst.*;

import bridge.domain.Bridge;
import bridge.domain.ResultFlag;
import bridge.domain.Map;
import bridge.domain.UpDownFlag;
import bridge.domain.User;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final User user;
    private final Bridge bridge;
    private final Map map;
    private int tryCount = 1;

    public BridgeGame(User user, Bridge bridge) {
        this.user = user;
        this.bridge = bridge;
        this.map = new Map(bridge, user);
    }

    public ResultFlag isCrossOver() {
        validateLength(bridge, user);
        for (int i = 0; i < user.getMovedLength(); i++) {
            if (bridge.getIndexOf(i) != user.getIndexOf(i)) {
                return ResultFlag.FAIL;
            }
        }
        if (bridge.getLength() == user.getMovedLength()) {
            return ResultFlag.SUCCESS;
        }
        return ResultFlag.NOTHING;
    }

    private void validateLength(Bridge bridge, User user) {
        if (bridge.getLength() < user.getMovedLength()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_BRIDGE_LENGTH_OVER_USER);
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(UpDownFlag flag) {
        user.move(flag);
        map.update();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount++;
        user.reset();
    }

    public String getMap() {
        return map.toString();
    }

    public int getTryCount() {
        return tryCount;
    }
}