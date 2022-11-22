package bridge.bridgeGame;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> answerGameBridge;
    private BridgeGameResult bridgeGameResult;
    private int moveCount = 0;
    private int reGameCount = 1; // 총 시도한 횟수는 첫 시도도 포함된다.

    public BridgeGame(List<String> answerGameBridge) {
        this.answerGameBridge = answerGameBridge;
        this.bridgeGameResult = new BridgeGameResult();
    }

    public int getMoveCount() {
        return moveCount;
    }

    public boolean isSameDirection(String moveDirection) {
        return moveDirection.equals(answerGameBridge.get(moveCount));
    }

    public boolean isSuccessGame() {
        return moveCount == answerGameBridge.size();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveDirection) {
        boolean move = true;
        if (moveDirection.equals("U")) {
            bridgeGameResult.addResultUp(move);
            moveCount++;
        }
        if (moveDirection.equals("D")) {
            bridgeGameResult.addResultUp(move);
            moveCount++;
        }
    }

    public void notMove(String moveDirection) {
        boolean move = false;
        if (moveDirection.equals("U")) {
            bridgeGameResult.addResultUp(move);
        }
        if (moveDirection.equals("D")) {
            bridgeGameResult.addResultDown(move);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        reGameCount++;
        moveCount = 0;
        bridgeGameResult.retryResultUpDown();
    }
}
