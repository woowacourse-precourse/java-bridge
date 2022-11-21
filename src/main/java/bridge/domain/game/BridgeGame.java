package bridge.domain.game;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private GameStatus gameStatus = GameStatus.PROGRESS;

    private int position;

    private int retryCount = 1;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(int bridgeSize) {
        if (position < bridgeSize) {
            position++;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        position = 0;
        retryCount++;
    }

    public boolean isGameSuccess(int bridgeSize) {
        return position == bridgeSize;
    }

    public boolean isGameInProgress() {
        return gameStatus.equals(GameStatus.PROGRESS);
    }

    public void exitGame() {
        gameStatus = GameStatus.EXIT;
    }

    public int getPosition() {
        return position;
    }

    public int getRetryCount() {
        return retryCount;
    }
}
