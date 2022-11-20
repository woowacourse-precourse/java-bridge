package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String PATH_BRIDGE_EQUAL = " O ";
    private static final String PATH_BRIDGE_NOT_EQUAL = " X ";
    private static final String BRIDGE_NOT_SELECTED = "   ";
    private static final String SEPARATOR = "|";
    private static final String BRIDGE_START = "[";
    private static final String BRIDGE_END = "]";
    private static final String GAME_SUCCESS_OR_FAILURE = "게임 성공 여부: ";
    private static final String TOTAL_TRY = "\n총 시도한 횟수: ";

    private List<String> resultBridge = new ArrayList<>();
    private List<String> resultPath = new ArrayList<>();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> path) {
        resultBridge = bridge;
        resultPath = path;

        System.out.print(BRIDGE_START);
        printBridge(UP, bridge, path);
        System.out.println(BRIDGE_END);

        System.out.print(BRIDGE_START);
        printBridge(DOWN, bridge, path);
        System.out.println(BRIDGE_END);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String judge, int gameTryCount) {
        System.out.println("최종 게임 결과");

        System.out.print(BRIDGE_START);
        printBridge(UP, resultBridge, resultPath);
        System.out.println(BRIDGE_END);
        System.out.print(BRIDGE_START);
        printBridge(DOWN, resultBridge, resultPath);
        System.out.println(BRIDGE_END + "\n");

        System.out.println(GAME_SUCCESS_OR_FAILURE + judge + TOTAL_TRY + gameTryCount);
    }

    private void printBridge(String UpDown, List<String> bridge, List<String> path) {
        for (int i = 0; i < path.size(); i++) {
            if (path.get(i).equals(UpDown) && path.get(i).equals(bridge.get(i)))
                System.out.print(PATH_BRIDGE_EQUAL);
            if (path.get(i).equals(UpDown) && !path.get(i).equals(bridge.get(i)))
                System.out.print(PATH_BRIDGE_NOT_EQUAL);
            if (!path.get(i).equals(UpDown))
                System.out.print(BRIDGE_NOT_SELECTED);
            if (path.size() - 1 != i)
                System.out.print(SEPARATOR);
        }
    }
}
