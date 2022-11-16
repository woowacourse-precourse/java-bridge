package bridge.config;

import bridge.domain.Command;

public class InputConfig {
    private static final int BRIDGE_MAX_LENGTH = 20;
    private static final int BRIDGE_MIN_LENGTH = 3;
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String NOT_ONE_WORD_ERROR = ERROR_MESSAGE + " 한 단어만 입력해 주세요.";
    private static final String NOT_IN_CORRECT_RANGE = ERROR_MESSAGE + " %d ~ %d 사이의 값만 입력해 주세요.";
    private static final String INVALID_INPUT_ERROR = ERROR_MESSAGE + " %c, %c만 입력해 주세요.";


    // 다리 길이 확인
    public void checkBridgeLength(String input) {
        isOneWord(input);
        isInCorrectRange(input.charAt(0));
    }

    public void checkMovingInput(String input) {
        isOneWord(input);
        isUpOrDown(input);
    }

    public void checkAskReGameInput(String input) {
        isOneWord(input);
        isRetryOrQuit(input);
    }

    private void isOneWord(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException(NOT_ONE_WORD_ERROR);
        }
    }

    private void isInCorrectRange(char c) {
        if (c > BRIDGE_MAX_LENGTH || c < BRIDGE_MIN_LENGTH) {
            String errMsg = String.format(NOT_IN_CORRECT_RANGE, BRIDGE_MIN_LENGTH, BRIDGE_MAX_LENGTH);
            throw new IllegalArgumentException(errMsg);
        }
    }

    private void isUpOrDown(String input) {
        String up = Command.UP.getAbbreviation();
        String down = Command.DOWN.getAbbreviation();
        if (input != up || input != down) {
            String errMsg = String.format(INVALID_INPUT_ERROR, up, down);
            throw new IllegalArgumentException(errMsg);
        }
    }

    private void isRetryOrQuit(String input) {
        String retry = Command.RETRY.getAbbreviation();
        String quit = Command.QUIT.getAbbreviation();
        if (input != retry || input != quit) {
            String errMsg = String.format(INVALID_INPUT_ERROR, retry, quit);
            throw new IllegalArgumentException(errMsg);
        }
    }
}
