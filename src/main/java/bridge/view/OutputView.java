package bridge.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    static List<String> up = new ArrayList<>();
    static List<String> down = new ArrayList<>();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public static void printMap(List<String> bridge, List<Boolean> status) {
        resetFormat();
        for(int i=0; i<status.size(); i++) {
            List<String> resultOne = getResultOne(bridge.get(i), status.get(i));
            up.add(resultOne.get(0));
            down.add(resultOne.get(1));
        }
        printBridge();
    }

    private static List<String> getResultOne(String step, Boolean status) {
        if(step.equals("U") && status.booleanValue() == TRUE)
            return List.of(" O ", "   ");
        if(step.equals("U") && status.booleanValue() == FALSE)
            return List.of("   ", " X ");
        if(step.equals("D") && status.booleanValue() == TRUE)
            return List.of("   ", " O ");
        return List.of(" X ", "   ");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(int count, String success) {
        System.out.println("최종 게임 결과");
        printBridge();
        System.out.println("\n게임 성공 여부: " + success);
        System.out.println("총 시도한 횟수: " + count);
    }

    private static void printBridge() {
        System.out.println(up.stream().map(n->String.valueOf(n)).collect(Collectors.joining("|","[","]")));
        System.out.println(down.stream().map(n->String.valueOf(n)).collect(Collectors.joining("|","[","]")));
        System.out.println();
    }

    private static void resetFormat() {
        up = new ArrayList<>();
        down = new ArrayList<>();
    }
}
