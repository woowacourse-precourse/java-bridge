package bridge;

import java.util.List;

import static bridge.enums.Sentence.*;

public class OutputView {

    public static void printStartGame() {
        System.out.println(GAME_START.getValue());
        System.out.println();
    }

    public static void printMap(List<String> upLine, List<String> downLine) {
        System.out.println(upLine.toString().replace(", ", "|"));
        System.out.println(downLine.toString().replace(", ", "|"));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
