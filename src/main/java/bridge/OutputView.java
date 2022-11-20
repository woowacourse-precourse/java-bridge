package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> bridge, List<String> moved) {
        printLine(bridge, moved, "U");
        printLine(bridge, moved, "D");
        System.out.println();
    }

    private static void printLine(List<String> bridge, List<String> moved, String updown) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < moved.size(); i++) {
            stringBuilder.append(getMovingResult(bridge.get(i), moved.get(i), updown));
            if (i < moved.size()-1) {
                stringBuilder.append("|");
            }
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    public static StringBuilder getMovingResult(String bridge, String moving, String updown) {
        StringBuilder stringBuilder = new StringBuilder();
        if (moving.equals(updown)) {
            stringBuilder.append(" ");
            stringBuilder.append(isSame(bridge, moving));
            stringBuilder.append(" ");
            return stringBuilder;
        }
        return new StringBuilder("   ");
    }

    public static String isSame(String bridge, String moving) {
        if (bridge.equals(moving)) {
            return "O";
        }
        return "X";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<String> bridge, List<String> moved, boolean isSuccess, int tryCount) {
    }
}
