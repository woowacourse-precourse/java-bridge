package bridge.domain;

import bridge.MoveResult;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int totalAttempt = 1;
    private Bridge bridge;
    private History history;

    public BridgeGame(Bridge bridge) {
        this.history = new History();
        this.bridge = bridge;
    }

    public int getTotalAttempt() {
        return totalAttempt;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MoveResult move(MoveCommand moveCommand) {
        history.appendMove(moveCommand);
        return getMoveResult();
    }

    private MoveResult getMoveResult() {
        if (bridge.isCorrect(history)) {
            return new MoveResult(history.getBridgeChars(), GameStatus.CORRECT);
        }
        if (bridge.isContinue(history)) {
            return new MoveResult(history.getBridgeChars(), GameStatus.CONTINUE);
        }

        return new MoveResult(history.getBridgeChars(), GameStatus.FAIL);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        totalAttempt++;
        history = new History();
    }
}
