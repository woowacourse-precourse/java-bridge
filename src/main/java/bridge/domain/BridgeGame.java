package bridge.domain;

import bridge.config.Direction;
import bridge.model.GameStatus;
import bridge.config.InvalidMoveException;
import bridge.model.PieceMove;

import java.util.Stack;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final Stack<PieceMove> moveTrace = new Stack<>();
    private GameStatus status = GameStatus.RUNNING;

    public BridgeGame(final Bridge bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Direction direction) throws InvalidMoveException {
        checkMoveValidation();
        boolean allowed = bridge.isAllow(moveTrace.size(), direction);
        moveTrace.add(new PieceMove(direction, allowed));
        updateStatus();
    }


    public GameStatus getStatus() {
        return this.status;
    }

    public String getPrintable(BridgePrinter printer) {
        return printer.getPrintable(this.moveTrace);
    }

    private void checkMoveValidation() {
        if (this.status != GameStatus.RUNNING) {
            throw new InvalidMoveException();
        }
    }

    private void updateStatus() {
        if (moveTrace.isEmpty()) {
            return;
        }
        checkWinOrLose();
    }

    private void checkWinOrLose() {
        if (!moveTrace.peek().getSuccess()) {
            this.status = GameStatus.LOSE;
            return;
        }
        if (moveTrace.size() == bridge.getNumOfCells()) {
            this.status = GameStatus.WIN;
        }
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        status = GameStatus.RUNNING;
        moveTrace.clear();
    }
}
