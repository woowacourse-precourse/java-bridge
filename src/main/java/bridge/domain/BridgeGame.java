package bridge.domain;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Bridge bridge;
    private int position;
    private int tryCount = 1;
    private GameStatus gameStatus;

    public BridgeGame(Bridge bridge) {
        init();
        this.bridge = bridge;
    }

    private void init() {
        position = 0;
        gameStatus = GameStatus.PLAYING;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Answer move(BridgeDirection direction) {
        Answer answer = bridge.canMove(position, direction);
        if (answer.isCorrect()) {
            return moveSuccess();
        }
        return moveFail();
    }

    private Answer moveSuccess() {
        position++;

        if (bridge.isEnd(position)) {
            gameStatus = GameStatus.SUCCESS;
        }
        return Answer.RIGHT;
    }

    private Answer moveFail() {
        gameStatus = GameStatus.FAIL;
        return Answer.WRONG;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount++;
        init();
    }

    public boolean isPlaying() {
        return gameStatus == GameStatus.PLAYING;
    }

    public GameStatus getStatus() {
        return gameStatus;
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean isFail() {
        return gameStatus == GameStatus.FAIL;
    }
}
