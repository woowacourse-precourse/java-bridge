package bridge.view;

import bridge.model.constant.Message;
import java.util.List;

public class OutputView {

    public void printMap(final List<String> userChoices, final List<Boolean> compareResults) {
        StringBuilder topLine = new StringBuilder(Message.START_MAP);
        StringBuilder bottomLine = new StringBuilder(Message.START_MAP);

        for (int index = 0; index < compareResults.size(); index++) {
            markAtTopLine(topLine, userChoices.get(index), compareResults.get(index));
            markAtBottomLine(bottomLine, userChoices.get(index), compareResults.get(index));
        }
        closeMap(topLine, bottomLine);

        System.out.println(topLine + Message.NEXT_LINE + bottomLine);
    }

    private void markAtTopLine(final StringBuilder topLine, final String choice, final boolean compareResult) {
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

    private void markAtBottomLine(final StringBuilder bottomLine, final String choice, final boolean compareResult) {
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

    private void closeMap(final StringBuilder topLine, final StringBuilder bottomLine) {
        topLine.replace(topLine.length() - 1, topLine.length(), Message.END_MAP);
        bottomLine.replace(bottomLine.length() - 1, bottomLine.length(), Message.END_MAP);
    }

    public void printResult(final boolean isSuccess, final int tryCount) {
        System.out.println(Message.SUCCESS_OR_FAIL + booleanToString(isSuccess));
        System.out.println(Message.TOTAL_TRY_COUNT_IS + tryCount);
    }

    private String booleanToString(final boolean isSuccess) {
        if (isSuccess) {
            return Message.SUCCESS;
        }
        return Message.FAIL;
    }

    public void printError(final IllegalArgumentException illegalArgumentException) {
        System.out.println(illegalArgumentException.getMessage());
    }
}
