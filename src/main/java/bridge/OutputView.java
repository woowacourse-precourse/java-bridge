package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_POINT = "[ ";
    private static final String END_POINT = " ]";
    private static final List<String> upBridge = new ArrayList<>();
    private static final List<String> downBridge = new ArrayList<>();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(int idx, List<String> bridge, String nextMove) {
        boolean canNextMove = CheckNextMove(idx, bridge, nextMove);
        nextMoving(nextMove, canNextMove);
        printUpBridge();
        printDownBridge();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public static void printUpBridge() {
        StringBuilder sb = new StringBuilder();
        sb.append(START_POINT).append(JoinBridge(upBridge)).append(END_POINT);
        System.out.print(sb);
        System.out.println();
    }

    public static void printDownBridge() {
        StringBuilder sb = new StringBuilder();
        sb.append(START_POINT).append(JoinBridge(downBridge)).append(END_POINT);
        System.out.println(sb);
    }

    public static String JoinBridge(List<String> upBridge) {
        return String.join(" | ", upBridge);
    }

    public static void nextMoving(String nextMove, boolean canNextMove) {
        if(Objects.equals(nextMove, "U")) {
            MoveUpBridge(canNextMove);
            notMoveDownBridge();
        }
        if(Objects.equals(nextMove, "D")) {
            MoveDownBridge(canNextMove);
            notMoveUpBridge();
        }
    }

    public static void notMoveUpBridge() {
        upBridge.add(" ");
    }
    public static void notMoveDownBridge() {
        downBridge.add(" ");
    }

    public static void MoveDownBridge(boolean canNextMove) {
        if(canNextMove) downBridge.add("O");
        if(!canNextMove) downBridge.add("X");
    }

    public static void MoveUpBridge(boolean canNextMove) {
        if(canNextMove) upBridge.add("O");
        if(!canNextMove)  upBridge.add("X");
    }

    public static boolean CheckNextMove(int idx, List<String> bridge, String nextMove) {
        if(Objects.equals(nextMove, "U")) {
            return SecondCheckNextMove(idx, bridge);
        }
        return !(SecondCheckNextMove(idx, bridge));
    }

    public static boolean SecondCheckNextMove(int idx, List<String> bridge) {
        return Objects.equals(bridge.get(idx), "U");
    }
}
