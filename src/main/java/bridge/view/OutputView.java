package bridge.view;

import bridge.model.Player;
import bridge.model.constant.Message;
import java.util.List;

public class OutputView {

    public static void printMap(final List<String> userChoices, final List<Boolean> compareResults) {
        StringBuilder topLine = new StringBuilder(Message.START_MAP);
        StringBuilder bottomLine = new StringBuilder(Message.START_MAP);

        for (int index = 0; index < compareResults.size(); index++) {
            markAtTopLine(topLine, userChoices.get(index), compareResults.get(index));
            markAtBottomLine(bottomLine, userChoices.get(index), compareResults.get(index));
        }

        closeMap(topLine, bottomLine);
        System.out.println(topLine + Message.NEXT_LINE + bottomLine);
    }

    private static void markAtTopLine(final StringBuilder topLine, final String choice, final boolean compareResult) {
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

    private static void markAtBottomLine(final StringBuilder bottomLine, final String choice, final boolean compareResult) {
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

    private static void closeMap(final StringBuilder topLine, final StringBuilder bottomLine) {
        topLine.replace(topLine.length() - 1, topLine.length(), Message.END_MAP);
        bottomLine.replace(bottomLine.length() - 1, bottomLine.length(), Message.END_MAP);
    }

    public static void printResult(final Player player, final List<Boolean> compareResults) {
        System.out.println(Message.GAME_RESULT_MESSAGE);
        printMap(player.getChoices(), compareResults);

        System.out.println(Message.SUCCESS_OR_FAIL + booleanToString(player.getIsSuccess()));
        System.out.println(Message.TOTAL_TRY_COUNT_IS + player.getTryCount());
    }

    private static String booleanToString(final boolean isSuccess) {
        if (isSuccess) {
            return Message.SUCCESS;
        }
        return Message.FAIL;
    }

    public static void printError(final IllegalArgumentException illegalArgumentException) {
        System.out.println(illegalArgumentException.getMessage());
    }
}
