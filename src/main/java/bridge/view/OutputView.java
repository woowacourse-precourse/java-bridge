package bridge.view;

import bridge.model.BridgeGame;

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
    public static void printMap(int index, List<String> bridge) {
        System.out.println(makeMap(index,bridge));
    }

    public static void printMapFail(int index, List<String> bridge) {

    }

    private static String makeMap(int index, List<String> bridge) {
        StringBuilder Up = new StringBuilder("[");
        StringBuilder Down = new StringBuilder("[");
        for (String block : bridge) {
            if (block.equals("U")) {
                Up.append(" O ");Down.append("   ");
            }
            if (block.equals("D")) {
                Up.append("   ");Down.append(" O ");
            }
            Up.append("|");Down.append("|");
        }
        Up.replace(Up.length()-1,Up.length(),"]");Down.replace(Down.length()-1,Down.length(),"]");
        return Up.append("\n").append(Down).toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult() {
    }
}
