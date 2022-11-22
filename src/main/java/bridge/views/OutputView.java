package bridge.views;

import static bridge.messages.OutputMessage.ATTEMPTS_NUMBER;
import static bridge.messages.OutputMessage.FAIL;
import static bridge.messages.OutputMessage.FINISH_GAME_RESULT;
import static bridge.messages.OutputMessage.GAME_SUCCESS_OR_FAIL;
import static bridge.messages.OutputMessage.START_MESSAGE;
import static bridge.messages.OutputMessage.SUCCESS;

import bridge.domain.enums.CrossStatus;

public class OutputView {

    public void printMap(final String movingResultMap) {
        System.out.println(movingResultMap);
        System.out.println();
    }

    public void printResult(final String movingResultMap, final int gameCount, final CrossStatus movingResultStatus) {

        System.out.println(FINISH_GAME_RESULT);
        System.out.println(movingResultMap);
        System.out.println();
        System.out.println(GAME_SUCCESS_OR_FAIL + getMessageOfStatus(movingResultStatus));
        System.out.println(ATTEMPTS_NUMBER + gameCount);
    }

    private String getMessageOfStatus(final CrossStatus movingResultStatus) {
        if (movingResultStatus == CrossStatus.FAIL) {
            return FAIL;
        }
        return SUCCESS;
    }

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
        System.out.println();
    }

    public void printErrorMessage(final String errorMessage) {
        System.out.println(errorMessage);
        System.out.println();
    }
}
