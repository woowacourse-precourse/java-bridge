package bridge;


import java.util.List;

import static bridge.enums.Sentence.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final static String COMMA = ", ";
    private final static String V_BAR = "|";


    public static void printStartGame() {
        System.out.println(GAME_START.getValue());
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> upLine, List<String> downLine) {
        System.out.println(upLine.toString().replace(COMMA, V_BAR));
        System.out.println(downLine.toString().replace(COMMA, V_BAR));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
