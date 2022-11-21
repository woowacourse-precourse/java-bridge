package bridge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String MOVE_IMPOSSIBLE = "X";
    private static final String MOVE_POSSIBLE = "O";
    private static final String SPACE = " ";
    private static final String MOVE_TO_DOWN = "D";
    private static final String MOVE_TO_UP = "U";
    private final List<String> highBridge = new ArrayList<>();
    private final List<String> lowBridge = new ArrayList<>();
    private boolean SUCCESS = false;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving, String bridgeStatus) {
        boolean movePossible = moving.equals(bridgeStatus);
        makeMoveBridge(moving, movePossible);
        return movePossible;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(TryNumber tryNumber) {
        clearBridge();
        tryNumber.add();
    }

    public List<String> getHighBridge() {
        return highBridge;
    }

    public List<String> getLowBridge() {
        return lowBridge;
    }

    public void gameSuccess() {
        SUCCESS = true;
    }

    public boolean isSuccess() {
        return SUCCESS;
    }

    private void makeMoveBridge(String moving, boolean success) {
        if (moving.equals(MOVE_TO_UP)) {
            up(success);
        }
        if (moving.equals(MOVE_TO_DOWN)) {
            down(success);
        }
    }

    private void clearBridge() {
        highBridge.clear();
        lowBridge.clear();
    }

    private void up(boolean success) {
        if (success) {
            highBridge.add(MOVE_POSSIBLE);
        }
        if (!success) {
            highBridge.add(MOVE_IMPOSSIBLE);
        }
        lowBridge.add(SPACE);
    }

    private void down(boolean success) {
        if (success) {
            lowBridge.add(MOVE_POSSIBLE);
        }
        if (!success) {
            lowBridge.add(MOVE_IMPOSSIBLE);
        }
        highBridge.add(SPACE);
    }
}
