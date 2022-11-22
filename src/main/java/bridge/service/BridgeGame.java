package bridge.service;

import static bridge.domain.GameCommand.RETRY;

import bridge.domain.BridgeCellType;
import bridge.domain.GameCommand;
import bridge.domain.MoveResult;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String INVALID_LOCATION_MESSAGE = "다리의 범위를 벗어난 위치입니다.";

    private final List<String> bridge;
    private final MoveResult moveResult;

    public BridgeGame(List<String> bridge, MoveResult moveResult) {
        this.bridge = bridge;
        this.moveResult = moveResult;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(int location, BridgeCellType moveCommand) {
        if (canMove(location, moveCommand)) {
            moveResult.success(moveCommand);
            return;
        }
        moveResult.fail(moveCommand);
    }

    private boolean canMove(int location, BridgeCellType moveCommand) {
        checkValidLocation(location);
        return Objects.equals(moveCommand.getCellType(), bridge.get(location));
    }

    private void checkValidLocation(int location) {
        if (location >= bridge.size() || location < 0) {
            throw new IllegalStateException(INVALID_LOCATION_MESSAGE);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameCommand retry(GameCommand gameCommand) {
        if (gameCommand.equals(RETRY)) {
            this.moveResult.increaseTryCount();
            this.moveResult.clearMoveHistory();
        }
        return gameCommand;
    }

    public MoveResult getMoveResult() {
        return moveResult;
    }

    public int getBridgeSize() {
        return bridge.size();
    }
}
