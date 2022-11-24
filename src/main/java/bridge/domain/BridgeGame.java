package bridge.domain;

import bridge.constant.BridgePosition;
import bridge.constant.ViewStatus;
import bridge.dto.GameResult;
import bridge.exception.IllegalMoveCommandException;
import bridge.exception.IllegalRetryCommandException;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Mover mover;
    private final String RETRY = "R";
    private final String QUIT = "Q";

    private int gameCount = 1;

    private BridgeGame(Bridge bridge) {
        this.mover = Mover.from(bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameResult move(String command) {
        validateMove(command);
        boolean isMatch = mover.move(command);
        return mover.resultOfMove(isMatch);
    }

    private void validateMove(String moveCommand) {
        if (moveCommand.equals(BridgePosition.UP.getPositionFormOfAlphabet()) ||
                moveCommand.equals(BridgePosition.DOWN.getPositionFormOfAlphabet())) {
            return;
        }
        throw new IllegalMoveCommandException();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public ViewStatus retry(String retryCommand) {
        validateRetry(retryCommand);

        if (retryCommand.equals(RETRY)) {
            mover.initialize();
            gameCount++;
            return ViewStatus.DETERMINE_MOVE;
        }
        return ViewStatus.LOSE;
    }

    private void validateRetry(String retryCommand) {
        if (retryCommand.equals(RETRY) ||
                retryCommand.equals(QUIT)) {
            return;
        }
        throw new IllegalRetryCommandException();
    }

    public int getGameCount() {
        return this.gameCount;
    }

    public static BridgeGame from(Bridge bridge) {
        return new BridgeGame(bridge);
    }
}
