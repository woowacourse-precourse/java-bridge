package bridge.config;

import bridge.domain.Command;

import java.util.regex.Pattern;

public class InputConfig {
    private static final int BRIDGE_MAX_LENGTH = 20;
    private static final int BRIDGE_MIN_LENGTH = 3;
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String NUMBER_PATTERN = "^[0-9]+$";
    private static final String NOT_ONE_WORD_ERROR = ERROR_MESSAGE + " 한 단어만 입력해 주세요.";
    private static final String NOT_IN_CORRECT_RANGE = ERROR_MESSAGE + " %d ~ %d 사이의 값만 입력해 주세요.";
    private static final String INVALID_INPUT_ERROR = ERROR_MESSAGE + " %s, %s만 입력해 주세요.";
    private static final String NOT_NUMBER_ERROR = ERROR_MESSAGE + " 숫자만 입력해 주세요.";


    // 다리 길이 확인
    public void checkBridgeLength(String input) {
        isNumber(input);
        isInCorrectRange(Integer.parseInt(input));
    }

    public void checkMovingInput(String input) {
        isOneWord(input);
        isUpOrDown(input);
    }

    public void checkAskReGameInput(String input) {
        isOneWord(input);
        isRetryOrQuit(input);
    }

    private void isNumber(String input) {
        if (!Pattern.matches(NUMBER_PATTERN, input)) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
    }

    private void isOneWord(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException(NOT_ONE_WORD_ERROR);
        }
    }

    private void isInCorrectRange(int i) {
        if (i > BRIDGE_MAX_LENGTH || i < BRIDGE_MIN_LENGTH) {
            String errMsg = String.format(NOT_IN_CORRECT_RANGE, BRIDGE_MIN_LENGTH, BRIDGE_MAX_LENGTH);
            throw new IllegalArgumentException(errMsg);
        }
    }

    private void isUpOrDown(String input) {
        String up = Command.UP.getAbbreviation();
        String down = Command.DOWN.getAbbreviation();

        if (!(input.equals(up) || input.equals(down))) {
            String errMsg = String.format(INVALID_INPUT_ERROR, up, down);
            throw new IllegalArgumentException(errMsg);
        }
    }

    private void isRetryOrQuit(String input) {
        String retry = Command.RETRY.getAbbreviation();
        String quit = Command.QUIT.getAbbreviation();

        if (!(input.equals(retry) || input.equals(quit))) {
            String errMsg = String.format(INVALID_INPUT_ERROR, retry, quit);
            throw new IllegalArgumentException(errMsg);
        }
    }
}
