package bridge.domain;

import bridge.enums.BridgeStatus;
import bridge.enums.GameCommand;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final int UP_INDEX = 0;
    private static final int DOWN_INDEX = 1;
    private static final int INIT_TRY_COUNT = 1;
    private static final int INIT_CURRENT_INDEX = 0;
    private static final int ONE = 1;

    private int tryCount;
    private int currentIndex;
    private List<String> bridge;
    private GameResult gameResult;

    public BridgeGame(List<String> bridge) {
        this.tryCount = INIT_TRY_COUNT;
        this.currentIndex = INIT_CURRENT_INDEX;
        this.bridge = bridge;
        gameResult = new GameResult();
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String direction) {
        int index = convertToIndex(direction);
        String answer = calculateAnswer(currentIndex, direction);
        gameResult.add(index, answer);
        currentIndex++;
        if (BridgeStatus.UNAVAILABLE.equals(answer)) {
            return false;
        }
        return true;
    }
    private int convertToIndex(String direction) {
        if (GameCommand.MOVE_UP.isSame(direction)) {
            return UP_INDEX;
        }
        return DOWN_INDEX;
    }
    private String calculateAnswer(int tryCount, String direction) {
        if (bridge.get(tryCount).equals(direction)) {
            return BridgeStatus.AVAILABLE.getValue();
        }
        return BridgeStatus.UNAVAILABLE.getValue();
    }
    public boolean isGameFail() {
        int lastIndex = currentIndex - ONE;
        if (gameResult.isUnavailable(lastIndex)) {
            return true;
        }
        return false;
    }
    public List<String>[] getResult() {
        return gameResult.getResult();
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount++;
        gameResult.clear();
        currentIndex = INIT_CURRENT_INDEX;
    }
    public boolean isEnd() {
        if (bridge.size() == currentIndex) {
            return true;
        }
        return false;
    }
    public int getTryCount() {
        return tryCount;
    }
}
