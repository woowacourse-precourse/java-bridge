package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final MovingHistory movingHistory;
    private final List<String> bridge;
    private int count;
    private int index;
    private boolean movingStatus;

    public BridgeGame(List<String> bridge) {
        this.movingHistory = new MovingHistory();
        this.bridge = bridge;
        this.count = 1;
        this.index = 0;
        this.movingStatus = true;
    }

    public int getCount() {
        return count;
    }

    public boolean isMovingStatus() {
        return movingStatus;
    }

    public MovingHistory getMovingHistory() {
        return movingHistory;
    }

    public boolean isEnd() {
        return index == bridge.size();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        movingStatus = moving.equals(bridge.get(index++));
        movingHistory.addMoving(moving,movingStatus);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String input) {
        if (input.equals("R")){
            count++;
            movingStatus = true;
            index = 0;
            movingHistory.clearHistory();
        }
    }
}
