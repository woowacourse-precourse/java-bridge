package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String SUCCESS = "O";
    private static final String FAIL = "X";
    private static final String SPACE = " ";
    private static final String BRIDGE_START = "[ ";
    private static final String BRIDGE_END = " ]";
    private static final String JOIN_OPERATOR = " | ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> choice, List<String> bridge) {
        printMapByLine(choice, bridge, UP);
        printMapByLine(choice, bridge, DOWN);

    }

    private static void printMapByLine(List<String> choice, List<String> bridge, String direction) {
        List<String> line = new ArrayList<String>();
        for (int i = 0; i < choice.size(); i++){
            line.add(findFactor(choice.get(i), bridge.get(i), direction));
        }
        System.out.print(BRIDGE_START);
        System.out.print(line.stream().collect(Collectors.joining(JOIN_OPERATOR)));
        System.out.print(BRIDGE_END);
        System.out.println();
    }

    private static String findFactor(String movement, String answer, String direction){
        if (!movement.equals(direction)) {
            return SPACE;
        }
        if (movement.equals(answer)) {
            return SUCCESS;
        }
        return FAIL;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(String result ,int totalTry) {
        System.out.println("게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + totalTry);
    }

    public static void printGuide(String message) {
        System.out.println(message);
    }

}
