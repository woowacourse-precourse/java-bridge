package bridge.engine;

import bridge.error.Error;
import bridge.model.Crossing;
import bridge.model.PassOrFail;
import bridge.model.TryCount;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final TryCount tryCount;

    public BridgeGame() {
        this.tryCount = new TryCount();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Crossing crossing, PassOrFail passOrFail) {
        if (Objects.isNull(crossing) || Objects.isNull(passOrFail)) {
            throw new IllegalArgumentException(Error.SYSTEM_ERROR.getMessage());
        }

        crossing.savePassOrFail(passOrFail);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
