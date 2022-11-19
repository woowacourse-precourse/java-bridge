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

    public void printResult(String result, int tryCount) {
        System.out.println();
        System.out.printf(SUCCESS_OR_FAILURE.getValue(), result);
        System.out.println();
        System.out.printf(TRY_COUNT.getValue(), tryCount);
    }
}
