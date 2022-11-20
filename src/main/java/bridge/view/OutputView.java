package bridge.view;

import java.util.List;

public class OutputView {

    public static void printGameStart() {
        System.out.println(OutputMessage.GAME_START_MESSAGE.getMessage());
    }

    public static void printInputNumber() {
        System.out.println(OutputMessage.INPUT_NUMBER_MESSAGE.getMessage());
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printInputMoving() {
        System.out.println(OutputMessage.INPUT_MOVING_MESSAGE.getMessage());
    }

    public static void printInputRestart() {
        System.out.println(OutputMessage.INPUT_RESTART_MESSAGE.getMessage());
    }

    public static void printOutputEnd() {
        System.out.println(OutputMessage.FINAL_GAME_RESULT.getMessage());
    }

    public static void printMap(List<List<String>> footPrint) {
        for (List<String> hierarchical : footPrint) {
            System.out.print(OutputMessage.START_SQUARE_BRACKET.getMessage());
            printMapMember(hierarchical);
            System.out.println(OutputMessage.END_SQUARE_BRACKET.getMessage());
        }
        System.out.println();
    }

    private static void printMapMember(List<String> hierarchical) {
        for (Integer index = 0; index < hierarchical.size() - 1; ++index) {
            System.out.print(hierarchical.get(index));
            System.out.print(OutputMessage.VERTICAL_BAR.getMessage());
        }
        System.out.print(hierarchical.get(hierarchical.size() - 1));
    }

    public static void printClearStatus(String crossStatus) {
        System.out.printf(OutputMessage.IS_GAME_CLEAR.getMessage(), crossStatus);
    }

    public static void printTryCount(int tryCount) {
        System.out.printf(OutputMessage.RETRY_COUNT.getMessage(), tryCount);
    }
}
