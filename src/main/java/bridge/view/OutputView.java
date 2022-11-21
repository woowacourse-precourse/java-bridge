package bridge.view;

import bridge.model.User;
import bridge.model.constant.Message;

import java.util.List;

public class OutputView {

    public static void printStart() {
        System.out.println(Message.START_MESSAGE);
    }

    public static void printInputBridgeSize() {
        System.out.println(Message.INPUT_BRIDGE_LENGTH);
    }

    public static void printInputMoving() {
        System.out.println(Message.INPUT_MOVING);
    }

    public static void printMap(List<String> userChoices, List<Boolean> compareResults) {
        StringBuilder topLine = new StringBuilder(Message.START_MAP);
        StringBuilder bottomLine = new StringBuilder(Message.START_MAP);

        for (int index = 0; index < compareResults.size(); index++) {
            markAtTopLine(topLine, userChoices.get(index), compareResults.get(index));
            markAtBottomLine(bottomLine, userChoices.get(index), compareResults.get(index));
        }

        printResult(topLine, bottomLine);
    }

    private static void markAtTopLine(StringBuilder topLine, String choice, boolean compareResult) {
        if (choice.equals(Message.UP)) {
            if (compareResult) {
                topLine.append(Message.CORRECT_LOG);
                return;
            }
            topLine.append(Message.FAIL_LOG);
            return;
        }
        topLine.append(Message.EMPTY_LOG);
    }

    private static void markAtBottomLine(StringBuilder bottomLine, String choice, boolean compareResult) {
        if (choice.equals(Message.DOWN)) {
            if (compareResult) {
                bottomLine.append(Message.CORRECT_LOG);
                return;
            }
            bottomLine.append(Message.FAIL_LOG);
            return;
        }
        bottomLine.append(Message.EMPTY_LOG);
    }

    private static void printResult(StringBuilder topLine, StringBuilder bottomLine) {
        topLine.replace(topLine.length() - 1, topLine.length(), Message.END_MAP);
        bottomLine.replace(bottomLine.length() - 1, bottomLine.length(), Message.END_MAP);
        System.out.println(topLine + Message.NEXT_LINE + bottomLine);
    }

    public static void printInputRetryCommand() {
        System.out.println(Message.INPUT_RETRY_COMMAND);
    }

    public static void printResult(User user, List<Boolean> compareResults) {
        System.out.println(Message.GAME_RESULT_MESSAGE);
        printMap(user.getChoices(), compareResults);

        System.out.println(Message.SUCCESS_OR_FAIL + booleanToString(user.getIsSuccess()));
        System.out.println(Message.TOTAL_TRY_COUNT + user.getTotalTryCount());
    }

    private static String booleanToString(boolean isSuccess) {
        if (isSuccess) {
            return Message.SUCCESS;
        }
        return Message.FAIL;
    }

    public static void printError(IllegalArgumentException illegalArgumentException) {
        System.out.println(illegalArgumentException.getMessage());
    }
}
