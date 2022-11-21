package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private int currentBlock;
    private int retries;
    private STATE state;

    public enum STATE {
        FAILED,
        MOVING,
        SUCCESS
    }

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.currentBlock = 0;
        this.retries = 0;
        this.state = STATE.MOVING;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getCurrentBlock() {
        return currentBlock;
    }

    public int getRetries() {
        return retries;
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
        if (!bridge.get(currentBlock).equals(moving)) {
            state = STATE.FAILED;
            return;
        }
        currentBlock++;
        if (currentBlock == bridge.size()) {
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
        currentBlock = 0;
        retries++;
        state = STATE.MOVING;
    }
}
