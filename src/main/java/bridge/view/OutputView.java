package bridge.view;

import bridge.model.User;

import java.util.List;

public class OutputView {

    public static final String CORRECT_LOG = "O|";
    public static final String FAIL_LOG = "X|";
    public static final String EMPTY_LOG = " |";
    public static final String SUCCESS = "성공";
    public static final String FAIL = "실패";
    public static final String UP = "U";
    public static final String DOWN = "D";
    public static final String START_MAP = "[";
    public static final String CLOSE_MAP = "\b]";
    public static final String NEXT_LINE = "\n";
    public static final String SUCCESS_OR_FAIL = "\n게임 성공 여부: ";
    public static final String TOTAL_TRY_COUNT = "총 시도한 횟수: ";

    public static void printStart() {
        System.out.println(bridge.model.constant.Message.START_MESSAGE);
    }

    public static void printInputBridgeSize() {
        System.out.println(bridge.model.constant.Message.INPUT_BRIDGE_LENGTH);
    }

    public static void printInputMoving() {
        System.out.println(bridge.model.constant.Message.INPUT_MOVING);
    }

    public static void printMap(List<String> userChoices, List<Boolean> compareResults) {
        StringBuilder topLine = new StringBuilder(START_MAP);
        StringBuilder bottomLine = new StringBuilder(START_MAP);

        for (int index = 0; index < compareResults.size(); index++) {
            markAtTopLine(topLine, userChoices.get(index), compareResults.get(index));
            markAtBottomLine(bottomLine, userChoices.get(index), compareResults.get(index));
        }

        printResult(topLine, bottomLine);
    }

    private static void markAtTopLine(StringBuilder topLine, String choice, boolean compareResult) {
        if (choice.equals(UP)) {
            if (compareResult) {
                topLine.append(CORRECT_LOG);
                return;
            }
            topLine.append(FAIL_LOG);
            return;
        }
        topLine.append(EMPTY_LOG);
    }

    private static void markAtBottomLine(StringBuilder bottomLine, String choice, boolean compareResult) {
        if (choice.equals(DOWN)) {
            if (compareResult) {
                bottomLine.append(CORRECT_LOG);
                return;
            }
            bottomLine.append(FAIL_LOG);
            return;
        }
        bottomLine.append(EMPTY_LOG);
    }

    private static void printResult(StringBuilder topLine, StringBuilder bottomLine) {
        topLine.append(CLOSE_MAP);
        bottomLine.append(CLOSE_MAP);
        System.out.println(topLine + NEXT_LINE + bottomLine);
    }

    public static void printInputRetryCommand() {
        System.out.println(bridge.model.constant.Message.INPUT_RETRY_COMMAND);
    }

    public static void printResult(User user, List<Boolean> compareResults) {
        System.out.println(bridge.model.constant.Message.GAME_RESULT_MESSAGE);
        printMap(user.getChoices(), compareResults);

        System.out.println(SUCCESS_OR_FAIL + booleanToString(user.getDoesSuccess()));
        System.out.println(TOTAL_TRY_COUNT + user.getTotalTryCount());
    }

    private static String booleanToString(boolean isSuccess) {
        if (isSuccess) {
            return SUCCESS;
        }
        return FAIL;
    }

    public static void printError(IllegalArgumentException illegalArgumentException) {
        System.out.println(illegalArgumentException.getMessage());
    }
}
