package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    static final String MOVING_UP = "U";
    static final String CAN_CROSS = "O";
    static final String CAN_NOT_CROSS = "X";
    static final String DID_NOT_CROSS = " ";
    private int totalGamePlay;
    private int userMoveCount;
    private boolean isClear;
    private boolean quitGame;

    private List<String> upBridge;
    private List<String> downBridge;

    public BridgeGame() {
        this.totalGamePlay = 1;
        this.userMoveCount = 0;
        this.isClear = false;
        this.quitGame = false;
        this.upBridge = new ArrayList<>();
        this.downBridge = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List<String> bridge, int index, String moving) {
        if (bridge.get(index).equals(moving)) {
            canCross(moving);
            userMoveCount += 1;
            checkGameSuccess(bridge);
            return true;
        }
        canNotCross(moving);
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        totalGamePlay += 1;
        userMoveCount = 0;
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
    }

    public void quit() {
        quitGame = true;
    }

    public void canCross(String moving) {
        if (moving.equals(MOVING_UP)) {
            upBridge.add(CAN_CROSS);
            downBridge.add(DID_NOT_CROSS);
            return;
        }
        upBridge.add(DID_NOT_CROSS);
        downBridge.add(CAN_CROSS);
    }

    public void canNotCross(String moving) {
        if (moving.equals(MOVING_UP)) {
            upBridge.add(CAN_NOT_CROSS);
            downBridge.add(DID_NOT_CROSS);
            return;
        }
        upBridge.add(DID_NOT_CROSS);
        downBridge.add(CAN_NOT_CROSS);
    }

    public void checkGameSuccess(List<String> bridge) {
        if (bridge.size() == userMoveCount) {
            isClear = true;
        }
    }

    public int getTotalGamePlay() {
        return totalGamePlay;
    }

    public List<String> getUpBridge() {
        return upBridge;
    }

    public List<String> getDownBridge() {
        return downBridge;
    }

    public boolean isClear() {
        return isClear;
    }

    public boolean isQuitGame() {
        return quitGame;
    }
}
