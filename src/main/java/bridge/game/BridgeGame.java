package bridge.game;

import bridge.domain.Bridge;
import bridge.domain.Direction;
import bridge.exception.ErrorMessage;
import bridge.exception.FailException;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final GameStatus gameStatus;

    public BridgeGame(List<String> bridge, GameStatus gameStatus) {
        this.bridge = new Bridge(bridge);
        this.gameStatus = gameStatus;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Direction direction) {
        try {
            bridge.move(direction);
            gameStatus.move(direction);
        } catch (FailException e) {
            gameStatus.makeFail(direction);
            throw new FailException();
        } catch (IllegalStateException e) {
            throw new IllegalStateException(ErrorMessage.INVALID_BRIDGE_STATUS);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void restart() {
        bridge.restart();
        gameStatus.restart();
    }

    public boolean isFinish() {
        return bridge.isArrive();
    }

    public String getMap() {
        return gameStatus.getBridgeStatus();
    }

    public GameStatus getStatus() {
        return gameStatus;
    }

}
