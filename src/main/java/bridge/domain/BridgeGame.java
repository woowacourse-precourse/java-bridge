package bridge.domain;

import static bridge.utils.Move.FAIL;
import static bridge.utils.Move.SUCCESS;
import static bridge.utils.message.ErrorMessagesUtil.RETRY_COMMAND;

import bridge.utils.Move;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private MoveResult moveResult;
    private final List<String> bridge;
    private boolean fail;
    private boolean finish;
    private int totalCount;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.moveResult = new MoveResult();
        this.fail = false;
        this.finish = false;
        totalCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MoveResult move(Move move) {
        if (canMoveNext(move)) {
            return moveSuccess(move);
        }
        return moveFail(move);
    }

    private boolean canMoveNext(Move move) {
        return bridge.get(nowIndex()).equals(move.getMoving());
    }

    private int nowIndex() {
        return moveResult.getStep();
    }

    private MoveResult moveSuccess(Move move) {
        moveResult.addMove(move, SUCCESS);
        return moveResult;
    }

    private MoveResult moveFail(Move move) {
        moveResult.addMove(move, FAIL);
        fail = true;
        return moveResult;
    }

    public boolean isFinish() {
        return finish || moveResult.isFinish(bridge.size());
    }

    public boolean isFail() {
        return fail;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String choiceRetry) {
        validateRetry(choiceRetry);
        this.finish = true;

        if (choiceRetry.equals("R")) {
            init();
        }
    }

    private void validateRetry(String choiceRetry) {
        if (choiceRetry.equals("R") || choiceRetry.equals("Q")) {
            return;
        }
        throw new IllegalArgumentException(RETRY_COMMAND.getMessage());
    }

    private void init() {
        this.moveResult = new MoveResult();
        this.fail = false;
        this.finish = false;
        this.totalCount++;
    }

    public MoveResult getMoveResult() {
        return moveResult;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
