package bridge.domain;

import static bridge.utils.Move.FAIL;
import static bridge.utils.Move.SUCCESS;

import bridge.utils.GameCommand;
import bridge.utils.Move;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private MoveResult moveResult;
    private final List<String> bridge;
    private int totalCount;

    public BridgeGame(List<String> bridge) {
        this.moveResult = new MoveResult();
        this.bridge = bridge;
        this.totalCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Move move(Move move) {
        if (canMoveNext(move)) {
            return moveSuccess(move);
        }
        return moveFail(move);
    }

    private boolean canMoveNext(Move move) {
        return bridge.get(nowIndex()).equals(move.getText());
    }

    private int nowIndex() {
        return moveResult.getStep();
    }

    private Move moveSuccess(Move move) {
        moveResult.addMove(move, SUCCESS);
        return SUCCESS;
    }

    private Move moveFail(Move move) {
        moveResult.addMove(move, FAIL);
        return FAIL;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(GameCommand command) {
        if (command.isPlay()) {
            init();
        }
    }

    private void init() {
        this.moveResult = new MoveResult();
        this.totalCount++;
    }

    public MoveResult getMoveResult() {
        return moveResult;
    }

    public String getResultText() {
        return moveResult.getResultText();
    }

    public int getTotalCount() {
        return totalCount;
    }

    public GameCommand isFinish() {
        return moveResult.isFinish(bridge.size());
    }
}
