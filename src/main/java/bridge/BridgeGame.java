package bridge;

import static bridge.constant.GameState.PROCEEDING_FAIL;
import static bridge.constant.GameState.PROCEEDING_SUCCESS;

import bridge.constant.GameState;
import bridge.constant.MovingDirection;
import bridge.domain.AnswerBridge;
import bridge.domain.UserBridge;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private UserBridge userBridge;
    private AnswerBridge answerBridge;
    private GameState gameState;
    private int currentPosition;
    private int tryCount;

    public BridgeGame(BridgeMaker bridgeMaker) {
        currentPosition = 0;
        gameState = PROCEEDING_SUCCESS;
        tryCount = 1;
        this.bridgeMaker = bridgeMaker;
    }

    public void setBridge(int bridgeSize) {
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        answerBridge = new AnswerBridge(bridge);
        userBridge = new UserBridge();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param movingDirection
     */
    public void move(MovingDirection movingDirection) {
        userBridge.setMovement(movingDirection);
        compareAndSetGameStatus(userBridge, answerBridge);
        currentPosition++;
        changeStatusToEndIfFinished();
    }

    private void changeStatusToEndIfFinished() {
        if (answerBridge.isLastPosition(this.currentPosition)) {
            gameState = GameState.toEnd(gameState);
        }
    }

    private void compareAndSetGameStatus(UserBridge userBridge, AnswerBridge answerBridge) {
        if (!isSameDirection(userBridge, answerBridge)) {
            gameState = PROCEEDING_FAIL;
        }
    }

    private boolean isSameDirection(UserBridge userBridge, AnswerBridge answerBridge) {
        return userBridge.getMovingDirection(currentPosition) == answerBridge.getMovingDirection(
            currentPosition);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        gameState = PROCEEDING_SUCCESS;
        currentPosition = 0;
        userBridge.reset();
        tryCount++;
    }

    public boolean isFinished() {
        return gameState.isEnd();
    }

    public boolean isNotFail() {
        return gameState.isNotFail();
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean hasSameDirectionAtPosition(int position, MovingDirection movingDirection) {
        return answerBridge.getMovingDirection(position) == movingDirection;
    }

    public boolean hasCorrectDirectionAtPosition(int position) {
        return userBridge.getMovingDirection(position) == answerBridge.getMovingDirection(position);
    }

    public String getResultPhrase() {
        return gameState.getResult();
    }
}
