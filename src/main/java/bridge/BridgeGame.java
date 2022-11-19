package bridge;

import bridge.constant.Error;
import bridge.constant.State;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int position = 0;
    private State state = State.Progress;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(final List<String> result, final String direction) {
        require(!"U".equals(direction) && !"D".equals(direction), Error.MOVE);
        require(state != State.Progress, Error.STATE);
        if (!result.get(position).equals(direction)) {
            state = State.Loss;
            return false;
        }
        position++;
        if (result.size() == position) state = State.Win;
        return true;
    }

    private void require(boolean condition, Error error) {
        if (condition) throw new IllegalArgumentException(error.getMsg());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        state = State.Progress;
        position = 0;
    }

    public State getGameState() {
        return state;
    }
}
