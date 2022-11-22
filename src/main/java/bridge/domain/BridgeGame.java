package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import static bridge.constants.CommandConstants.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final int INIT_TRY_COUNT = 1;

    private List<String> bridge;
    private List<String> currentUpBridge;
    private List<String> currentDownBridge;
    private int tryCount;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.tryCount = INIT_TRY_COUNT;
        initBridge();
    }

    private void initBridge() {
        this.currentUpBridge = new ArrayList<>();
        this.currentDownBridge = new ArrayList<>();
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getCurrentUpBridge() {
        return currentUpBridge;
    }

    public List<String> getCurrentDownBridge() {
        return currentDownBridge;
    }

    public int getTryCount() {
        return tryCount;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param movement
     * @param index
     */
    public boolean move(String movement, int index) {
        if (bridge.get(index).equals(movement)) {
            moveOorX(MOVE_INPUT_O.getCommand(), movement);
            return true;
        }
        if (!bridge.get(index).equals(movement)) {
            moveOorX(MOVE_INPUT_X.getCommand(), movement);
        }
        return false;
    }

    private void moveOorX(String ox, String movement) {
        if (movement.equals(MOVE_U.getCommand())) {
            currentUpBridge.add(ox);
            currentDownBridge.add(MOVE_INPUT_BLANK.getCommand());
        }
        if (movement.equals(MOVE_D.getCommand())) {
            currentDownBridge.add(ox);
            currentUpBridge.add(MOVE_INPUT_BLANK.getCommand());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param retry
     */
    public boolean retry(String retry) {
        if (retry.equals(RETRY_R.getCommand())) {
            this.tryCount++;
            initBridge();
            return true;
        }
        return false;
    }
}
