package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public static final String UP_BRIDGE = "U";
    public static final String DOWN_BRIDGE = "D";

    private final List<String> bridge;
    private final Player player;
    private final MovingMap movingMap = new MovingMap();
    private int tryCount = 1;
    private boolean isEnd = false;

    public BridgeGame(List<String> bridge, Player player) {
        this.bridge = bridge;
        this.player = player;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        assertGameIsNotEnd();

        player.move(moving);
        movingMap.addMoving(moving, isLatestMovingSuccess());

        if (isPlayerLocatedEnd() && !isGameFailed()) {
            isEnd = true;
        }
    }

    private void assertGameIsNotEnd() {
        if (isEnd) {
            throw new IllegalStateException("게임이 이미 종료 되었습니다.");
        }
    }

    private boolean isPlayerLocatedEnd() {
        int position = player.getPosition();
        int endPosition = bridge.size() - 1;

        return position == endPosition;
    }

    public boolean isGameEnd() {
        return isEnd;
    }

    public boolean isGameClear() {
        return isEnd && !isGameFailed();
    }

    public boolean isGameFailed() {
        if (player.getPosition() < 0) {
            return false;
        }

        return !isLatestMovingSuccess();
    }

    private boolean isLatestMovingSuccess() {
        String latestMoving = player.getLatestMoving();
        int position = player.getPosition();

        return bridge.get(position).equals(latestMoving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount++;
        isEnd = false;
        player.reset();
        movingMap.clear();
    }

    public void finishGame() {
        isEnd = true;
    }

    public int getTryCount() {
        return tryCount;
    }

    public MovingMap getMovingMap() {
        return movingMap;
    }
}
