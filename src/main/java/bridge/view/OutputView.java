package bridge.view;

import bridge.model.message.Message;

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
    public void printMap(final List<String> userChoices, final List<Boolean> compareResults) {
        StringBuilder topLine = new StringBuilder(Message.START_MAP.getMessage());
        StringBuilder bottomLine = new StringBuilder(Message.START_MAP.getMessage());

        for (int index = 0; index < compareResults.size(); index++) {
            markAtTopLine(topLine, userChoices.get(index), compareResults.get(index));
            markAtBottomLine(bottomLine, userChoices.get(index), compareResults.get(index));
        }
        closeMap(topLine, bottomLine);

        System.out.println(topLine + Message.NEXT_LINE.getMessage() + bottomLine);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(final boolean isSuccess, final int tryCount) {
        System.out.println(Message.SUCCESS_OR_FAIL.getMessage() + booleanToString(isSuccess));
        System.out.println(Message.TOTAL_TRY_COUNT_IS.getMessage() + tryCount);
    }

    public void printError(IllegalArgumentException illegalArgumentException) {
        System.out.println(illegalArgumentException.getMessage());
    }

    private String booleanToString(final boolean isSuccess) {
        if (isSuccess) {
            return Message.SUCCESS.getMessage();
        }
        return Message.FAIL.getMessage();
    }

    private void markAtTopLine(final StringBuilder topLine, final String choice, final boolean compareResult) {
        if (choice.equals(Message.GO_UP.getMessage())) {
            if (compareResult) {
                topLine.append(Message.CORRECT_LOG.getMessage());
                return;
            }

            topLine.append(Message.FAIL_LOG.getMessage());
            return;
        }
        topLine.append(Message.EMPTY_LOG.getMessage());
    }

    private void markAtBottomLine(final StringBuilder bottomLine, final String choice, final boolean compareResult) {
        if (choice.equals(Message.GO_DOWN.getMessage())) {
            if (compareResult) {
                bottomLine.append(Message.CORRECT_LOG.getMessage());
                return;
            }

            bottomLine.append(Message.FAIL_LOG.getMessage());
            return;
        }
        bottomLine.append(Message.EMPTY_LOG.getMessage());
    }

    private void closeMap(final StringBuilder topLine, final StringBuilder bottomLine) {
        topLine.replace(topLine.length() - 1, topLine.length(), Message.END_MAP.getMessage());
        bottomLine.replace(bottomLine.length() - 1, bottomLine.length(), Message.END_MAP.getMessage());
    }
}
