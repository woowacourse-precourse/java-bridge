package bridge.views;

import java.util.List;

import static bridge.enums.Sentence.*;

public class OutputView {
    private final static String COMMA = ", ";
    private final static String VERTI_BAR = "|";


    public static void printStartGame() {
        System.out.println(GAME_START.getValue());
        System.out.println();
    }

    public static void printMap(List<String> upLine, List<String> downLine) {
        System.out.println(upLine.toString().replace(COMMA, VERTI_BAR));
        System.out.println(downLine.toString().replace(COMMA, VERTI_BAR));
    }

    public static void printResult(String result, int tryCount) {
        System.out.println();
        System.out.printf(SUCCESS_OR_FAILURE.getValue(), result);
        System.out.println();
        System.out.printf(TRY_COUNT.getValue(), tryCount);
    }
}
