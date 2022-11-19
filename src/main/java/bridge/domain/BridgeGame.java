package bridge.domain;

import bridge.constant.GameRetryCommand;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final User user;

    public BridgeGame(Bridge bridge, User user) {
        this.bridge = bridge;
        this.user = user;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Boolean move(String direction) {
        user.stepForward(direction);
        return bridge.canCross(user.getStep(), direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Boolean retry(String command) {
        if (command.equals(GameRetryCommand.RETRY.getFirstLetter())) {
            user.increaseRetryCount();
            user.stepInit();
            return true;
        }
        return false;
    }

    public Boolean isEnd() {
        return bridge.getSize() == user.getStep();
    }

    public Integer getTryCount() {
        return user.getTryCount();
    }

    public List<String> getBridgeDirections() {
        return bridge.getDirections();
    }

    public List<String> getUserMoveHistory() {
        return user.getMoveHistory();
    }
}
