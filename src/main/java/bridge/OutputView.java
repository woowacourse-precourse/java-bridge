package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static bridge.Application.bridgeGame;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String START_POINT = "[ ";
    private final String END_POINT = " ]";
    private final String UP_BRIDGE_BTN = "U";
    private final String DOWN_BRIDGE_BTN = "D";
    private final String BLANK = " ";
    private final String WALK_SUCCESS = "O";
    private final String WALK_FAIL = "X";
    private final List<String> upBridge = new ArrayList<>();
    private final List<String> downBridge = new ArrayList<>();
    private boolean SUCCESS_OR_FAIL = true;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean printMap(int idx, List<String> bridge, String nextMove) {
        boolean canNextMove = CheckNextMove(idx, bridge, nextMove);
        nextMoving(nextMove, canNextMove);
        printBridge();
        return SUCCESS_OR_FAIL;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printBridge() {
        printUpBridge();
        printDownBridge();
    }
    public void printResult(int gameCnt, int CURRENT_LOCATION, boolean successOrFail) {
        if(CURRENT_LOCATION==0 && successOrFail) bridgeGame.retryAnswerIsSuccess(gameCnt);
    }

    public void getSuccessOrFail() {
        SUCCESS_OR_FAIL = true;
    }

    public void bridgeInitialize() {
        upBridge.clear();;
        downBridge.clear();
    }

    public void printUpBridge() {
        StringBuilder sb = new StringBuilder();
        sb.append(START_POINT).append(JoinBridge(upBridge)).append(END_POINT);
        System.out.print(sb);
        System.out.println();
    }

    public void printDownBridge() {
        StringBuilder sb = new StringBuilder();
        sb.append(START_POINT).append(JoinBridge(downBridge)).append(END_POINT);
        System.out.println(sb);
    }

    public String JoinBridge(List<String> upBridge) {
        return String.join(" | ", upBridge);
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
}
