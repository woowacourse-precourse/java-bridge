package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private List<String> moves;
    private int retries;
    private STATE state;

    public enum STATE {
        FAILED,
        MOVING,
        SUCCESS
    }

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.moves = new ArrayList<>();
        this.retries = 1;
        this.state = STATE.MOVING;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getRetries() {
        return retries;
    }

    public List<String> getMoves() {
        return moves;
    }

    public STATE getState() {
        return state;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        moves.add(moving);
        if (!bridge.get(moves.size() - 1).equals(moving)) {
            state = STATE.FAILED;
            return;
        }
        if (moves.size() == bridge.size()) {
            state = STATE.SUCCESS;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String command) {
        if (command.equals("Q")) {
            return;
        }
        moves = new ArrayList<>();
        retries++;
        state = STATE.MOVING;
    }
}
