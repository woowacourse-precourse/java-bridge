package bridge;

import bridge.model.Bridge;
import bridge.model.Direction;
import bridge.model.DrawType;
import bridge.model.GameStatus;
import bridge.model.MoveResult;
import bridge.model.Player;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final Player player;
    private GameStatus status;

    public BridgeGame(Bridge bridge, Player player) {
        this.bridge = bridge;
        this.player = player;
        status = GameStatus.PLAYING;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MoveResult move(Direction direction) {
        MoveResult moveResult = player.move(bridge, direction);
        changeStatusByMoveResult(moveResult);
        return moveResult;
    }

    public void changeStatusByMoveResult(MoveResult moveResult) {
        if (moveResult.compareDrawType(DrawType.FAIL)) {
            changeStatus(GameStatus.END);
            return;
        }
        if (player.moveToEnd(bridge)) {
            changeStatus(GameStatus.QUIT);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    private void changeStatus(GameStatus status) {
        this.status = status;
    }

    public boolean end() {
        return status == GameStatus.END;
    }

    public boolean quit() {
        return status == GameStatus.QUIT;
    }
}
