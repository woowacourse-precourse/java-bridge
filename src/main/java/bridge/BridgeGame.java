package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    ErrorCheck errorCheck = new ErrorCheck();
    private final int END_GAME = 0;
    private final String QUIT = "Q";
    private final String UP_BRIDGE_BTN = "U";
    private final String DOWN_BRIDGE_BTN = "D";
    private final String BLANK = " ";
    private final String WALK_SUCCESS = "O";
    private final String WALK_FAIL = "X";
    private boolean SUCCESS_OR_FAIL = true;
    private final List<String> upBridge = new ArrayList<>();
    private final List<String> downBridge = new ArrayList<>();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int idx, List<String> bridge, String nextMove) {
        boolean canNextMove = CheckNextMove(idx,bridge, nextMove);
        nextMoving(nextMove, canNextMove);
        return SUCCESS_OR_FAIL;
    }

    public List<String> getUpBridge() {
        return upBridge;
    }

    public List<String> getDownBridge() {
        return downBridge;
    }

    public void bridgeInitialize() {
        upBridge.clear();;
        downBridge.clear();
    }

    public void getSuccessOrFail() {
        SUCCESS_OR_FAIL = true;
    }

    public void nextMoving(String nextMove, boolean canNextMove) {
        if(Objects.equals(nextMove, UP_BRIDGE_BTN)) {
            MoveUpBridge(canNextMove);
            notMoveDownBridge();
        }
        if(Objects.equals(nextMove, DOWN_BRIDGE_BTN)) {
            MoveDownBridge(canNextMove);
            notMoveUpBridge();
        }
    }

    public void notMoveUpBridge() {
        upBridge.add(BLANK);
    }
    public void notMoveDownBridge() {
        downBridge.add(BLANK);
    }

    public void MoveDownBridge(boolean canNextMove) {
        if(canNextMove) downBridge.add(WALK_SUCCESS);
        if(!canNextMove) {
            downBridge.add(WALK_FAIL);
            SUCCESS_OR_FAIL = false;
        }
    }

    public void MoveUpBridge(boolean canNextMove) {
        if(canNextMove) upBridge.add(WALK_SUCCESS);
        if(!canNextMove)  {
            upBridge.add(WALK_FAIL);
            SUCCESS_OR_FAIL = false;
        }
    }

    public boolean CheckNextMove(int idx, List<String> bridge, String nextMove) {
        if(Objects.equals(nextMove, UP_BRIDGE_BTN)) {
            return SecondCheckNextMove(idx, bridge);
        }
        return !(SecondCheckNextMove(idx, bridge));
    }

    public boolean SecondCheckNextMove(int idx, List<String> bridge) {
        return Objects.equals(bridge.get(idx), UP_BRIDGE_BTN);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int retry(String answerOfRetry, int BRIDGE_LENGTH) {
        if(answerOfRetry.equals(QUIT)) {
            return END_GAME;
        }
        return BRIDGE_LENGTH;
    }
}
